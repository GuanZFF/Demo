package pers.zhenfeng.redis;


import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Grow-Worm
 * @date 2019/04/28
 */
public class TestJedis {

    private static Jedis jedis = new Jedis("140.143.201.74", 8000);

    static {
        jedis.auth("123456");
    }

    @Test
    public void stringTest() {
        jedis.set("k7", "123456");
        System.out.println(jedis.get("password"));
    }

    @Test
    public void listTest() {
        jedis.lpush("lname", "guan", "zhen", "feng");
        System.out.println(jedis.lpop("lname"));
    }

    @Test
    public void setTest() {
        jedis.sadd("sname", "guan", "zhen", "feng");
        System.out.println(jedis.spop("sname"));
    }

    @Test
    public void hashTest() {
        Map<String, String> hash = new HashMap<>();
        hash.put("name", "guanzf");

        jedis.hset("hname", hash);
    }

    @Test
    public void zsetTest() {
        jedis.zadd("zname", 10.0, "v1");
        jedis.zadd("zname", 30.0, "v3");
        jedis.zadd("zname", 20.0, "v2");
    }

}
