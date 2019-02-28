package com.test.redisoperatives;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;

public class RedisTest {
    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    public static void main(String[] args) {

        JedisPool jedisPool = null;
        Jedis jedis = null;
        Pipeline pipeline = null;
        int num = -1;
        try {
            jedisPool = RedisPool.getConn();
            jedis = jedisPool.getResource();
            System.out.println("操作前，全部Key值：" + jedis.keys("*"));
            pipeline = jedis.pipelined();
            HashMap<String,String> hm=new HashMap();

            String key="h1";

            pipeline.hincrBy(key,"click",1);
            pipeline.hincrBy(key,"show",2);



            // 保留20天
            pipeline.expire(key, 3600 * 24 * 20);
            logger.debug("incr_key = {} ", key);
            pipeline.sync();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("error");
            logger.error("num = " + num, e);
        } finally {
            // TODO: handle finally clause
            if (jedis != null)
                jedis.close();
        }
    }
}
