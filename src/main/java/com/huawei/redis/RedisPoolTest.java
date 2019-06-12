package com.huawei.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolTest {


    public static void main(String[] args) {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(50);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxWaitMillis(200000);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost");
        Jedis jedis = jedisPool.getResource();
        int i = 0;

        try {

            long starttime = System.currentTimeMillis();
            while (System.currentTimeMillis() - starttime < 1000) {
                jedis.sadd("barry" + i, "" + Math.random());
                i++;
            }
        } finally {
            jedis.close();
        }

        System.out.println("redis每秒操作：" + i + "次 ");


    }


}
