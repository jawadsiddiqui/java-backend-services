package com.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisExample {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("key1", "this is my key");
        System.out.println(jedis.get("key1"));

        jedis.del("key1");
        System.out.println(jedis.get("key1"));
        jedis.close();

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1);
        poolConfig.setMaxIdle(1);
        poolConfig.setMinIdle(1);
        poolConfig.setTestOnBorrow(true);

        JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379);
        Jedis jedis1 = jedisPool.getResource();
        jedis.set("mykey", "myvalue");
        String value = jedis.get("mykey");

        JedisPool jedisPool1 = new JedisPool(poolConfig, "localhost", 6379);
        Jedis jedis2 = jedisPool1.getResource();
        jedis.set("mykey", "myvalue");
        String value1 = jedis.get("mykey");

        jedis.close();
        jedisPool.close();

    }
}
