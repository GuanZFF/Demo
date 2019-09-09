package pers.zhenfeng.redis;

import redis.clients.jedis.Jedis;

/**
 * @author Grow-Worm
 * @date 2019/08/29
 */
public class RedisDemo1 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println(jedis.get("foo"));
    }

}
