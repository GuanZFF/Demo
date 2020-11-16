package pers.zhenfeng.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.params.SetParams;

import java.sql.*;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Grow-Worm
 * @date 2019/08/29
 */
public class RedisDemo1 {

    private static Jedis jedis = new Jedis("140.143.201.74", 6379);

    public static void main(String[] args) throws Exception {

        System.out.println(jedis.get("name"));

        Connection connection = DriverManager.getConnection("jdbc:mysql://cdb-oef40sfc.bj.tencentcdb.com:10032/test", "root", "Guanzf123");

        new Thread(() -> {

            Jedis jedis = new Jedis("140.143.201.74", 6379);

            while (true) {
                int random = new Random().nextInt(1000000);

                System.err.println("----------" + random + "----------");

                jedis.publish("test", String.valueOf(random));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "produce");

        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                acquireLock(message);

                try {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT id FROM `order` WHERE `orderId` = " + message);

                    if (!resultSet.next()) {
                        System.out.println(Thread.currentThread().getName() + " " + message);
                        connection.createStatement().execute("INSERT INTO `order`(`orderId`) VALUE (" + message + ");");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " 消息已经产生");
                    }

                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
                }

                releaseLock(message);
            }
        };

        new Thread(() -> new Jedis("140.143.201.74", 6379).subscribe(jedisPubSub, "test"), "consume1").start();
        new Thread(() -> new Jedis("140.143.201.74", 6379).subscribe(jedisPubSub, "test"), "consume2").start();


        System.out.println("complete!!!");

        System.in.read();
    }


    public static void acquireLock(String key) {

        String value = jedis.set(key, "1", SetParams.setParams().ex(10).nx());

        if (value == null) {
            return;
        }
    }

    public static long releaseLock(String key) {
        return jedis.del(key);
    }

}
