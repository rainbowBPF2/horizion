package Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengfei on 2017/9/12.
 */

@Component("redisCache")
public class RedisCacheImpl <V> implements RedisCache<String, V> {

    static{
        PropertyConfigurator.configure("log4j.properties");
    }

    private static Logger logger = Logger.getLogger(RedisCacheImpl.class);
    private final int EXPIRE_TIME = 3600 * 24;

    @Autowired
    private JedisClient client;

    public boolean set(String key, V value) {
        return set(key, value, EXPIRE_TIME);
    }

    public boolean set(String key, V value, int expireTime) {
        Jedis jedis = null;

        if (StringUtils.isEmpty(key)) {
            logger.info("key is null");
            return false;
        }

        String k = key;
        String v = CacheUtils.toJsonString(value);

        try {
            jedis = client.getResource();
            jedis.setex(k, expireTime, v);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Jedis setex failed");
            this.client.returnBrokenResource(jedis);

        } finally {
            this.client.returnResource(jedis);
        }
        return false;
    }

    public V get(String key) {
        Jedis jedis = null;
        V value = null;

        if (StringUtils.isEmpty(key)) {
            logger.error("key is empty");
            return null;
        }

        try {
            jedis = client.getResource();
            value = (V) jedis.get(key);
        } catch (Exception e) {
            logger.error("get value failed");
            client.returnBrokenResource(jedis);
        } finally {
            this.client.returnResource(jedis);
        }
        return value;
    }

    public boolean remove(String key) {

        if (StringUtils.isEmpty(key)) {
            logger.error("Key is empty");
            return false;
        }

        long result = 0l;
        Jedis jedis = null;
        try {
            jedis = client.getResource();
            result = jedis.del(key);
        } catch (Exception e) {
            logger.error("remove key failed");
            this.client.returnBrokenResource(jedis);
        } finally {
            this.client.returnResource(jedis);
        }

        return result > 0 ? true : false;
    }

    public boolean hset(String cacheKey, String key, V value) {
        if (StringUtils.isEmpty(cacheKey) || StringUtils.isEmpty(key)) {
            logger.error("Key/cacheKey is empty");
            return false;
        }

        long result = 0l;
        Jedis jedis = null;

        try {
            jedis = client.getResource();
            String val = CacheUtils.toJsonString(value);
            result = jedis.hset(cacheKey, key, val);
        } catch (Exception e) {
            logger.error("hset failed");
            this.client.returnBrokenResource(jedis);
        } finally {
            this.client.returnResource(jedis);
        }

        return result > 0 ? true : false;
    }

    public V hget(String cacheKey, String key) {

        if (StringUtils.isEmpty(cacheKey) || StringUtils.isEmpty(key)) {
            logger.error("Key/CacheKey is empty");
            return null;
        }

        Jedis jedis = null;

        try {
            jedis = client.getResource();
            String value = jedis.hget(cacheKey, key);
            V result = CacheUtils.parseJsonObj(value);
            return result;
        } catch (Exception e) {
            logger.error("hget failed");
            this.client.returnBrokenResource(jedis);
        } finally {
            this.client.returnResource(jedis);
        }

        return null;
    }


    public Map<String, V> hget(String cacheKey) {
        if (StringUtils.isEmpty(cacheKey)) {
            logger.error("CacheKey is empty");
            return null;
        }

        Jedis jedis = null;

        try {
            jedis = client.getResource();
            Map<String, String> map = jedis.hgetAll(cacheKey);
            Map<String, V> mapResult = new HashMap<String, V>();
            for (String key : map.keySet()) {
                String v = map.get(key);
                V obj = CacheUtils.parseJsonObj(v);
                mapResult.put(key, obj);
            }

            map.clear();
            map = null;

            return mapResult;
        } catch (Exception e) {
            logger.error("remove key failed");
            this.client.returnBrokenResource(jedis);
        } finally {
            this.client.returnResource(jedis);
        }

        return null;
    }
}
