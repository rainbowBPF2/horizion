package Utility;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by pengfei on 2017/9/11.
 */

@Component
public class JedisClient {

    private final static  Logger logger= Logger.getLogger(JedisClient.class);//using reflect.

    @Autowired
    private JedisPool pool;

    public Jedis getResource(){
        Jedis client=null;

        try {
            client=pool.getResource();
        } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return client;
    }

    public void disconnect(Jedis client){
        client.disconnect();
    }

    public void returnResource(Jedis client){
        if(client!=null){
            try {
                pool.returnResource(client);
            } catch (Exception e) {
                logger.error("Return Jedis client fail");
                e.printStackTrace();
            }
        }
    }

    //return and destroy client.
    public void returnBrokenResource(Jedis client){
        if(client!=null){
            try{
                pool.returnBrokenResource(client);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

}



