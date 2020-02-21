package pers.zhenfeng.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Grow-Worm
 * @date 2019/04/23
 */
public class RedisDemo {

    public static void main(String[] args) {
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("140.143.201.74", 6380));

        JedisCluster jedisCluster = new JedisCluster(hostAndPorts);
        jedisCluster.set("name", "guanzhenfeng");

        System.out.println(jedisCluster.get("name"));

    }

}
