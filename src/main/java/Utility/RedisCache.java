package Utility;

import java.util.Map;

/**
 * Created by pengfei on 2017/9/12.
 */
public interface RedisCache<K, V> {

    boolean set(K key, V value);

    boolean set(K key, V value, int expireTime);

    V get(K key);

    boolean remove(K key);

    boolean hset(String cacheKey, K key, V value);

    V hget(String cacheKey, K key);

    Map<K, V> hget(String cacheKey);

}
