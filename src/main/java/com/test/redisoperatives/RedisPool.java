package com.test.redisoperatives;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

public class RedisPool {
    private static JedisPool conn;

    static {
        conn = new JedisPool(new GenericObjectPoolConfig(), "localhost",6379 , 2000);
    }

    public static JedisPool getConn() {
        return conn;
    }
}
