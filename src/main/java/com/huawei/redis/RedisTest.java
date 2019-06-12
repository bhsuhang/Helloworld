package com.huawei.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost", 6379, 100000);
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

        System.out.println("redis每秒操作：" + i + "次");





        //Jedis jedis = new Jedis("localhost", 6379, 100000);

    }
}
