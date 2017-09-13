package rainbow;

import java.util.List;
import redis.clients.jedis.Jedis;

/**
 * Created by pengfei on 2017/9/11.
 */
public class JedisTest {

    public static void main(String[] args) {
        Jedis client = new Jedis("localhost", 6379);
        client.set("client", "redis");
        client.lpush("list", "b");
        client.rpush("list", "c");

        client.del("list");
        client.lpush("list", "a");

        String v1 = client.get("client");
        List<String> list = client.lrange("list", 0, -1);

        for (String s : list)
            System.out.println(s);

        System.out.println(client.get("client"));
    }
}
