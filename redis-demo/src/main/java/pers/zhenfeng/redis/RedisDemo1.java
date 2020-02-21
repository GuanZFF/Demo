package pers.zhenfeng.redis;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @author Grow-Worm
 * @date 2019/08/29
 */
public class RedisDemo1 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("140.143.201.74", 6379);


        for (int i = 0; i < 1000; i++) {
            String randomValue = UUID.randomUUID().toString();

            jedis.set("test_" + i, randomValue);
        }

        System.out.println("complete!!!");
    }

}
