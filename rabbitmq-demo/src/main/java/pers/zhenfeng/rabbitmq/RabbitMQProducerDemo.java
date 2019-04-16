package pers.zhenfeng.rabbitmq;

import com.google.common.collect.Maps;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Grow-Worm
 * @date 2019/04/02
 */
public class RabbitMQProducerDemo {

    private static String queueName = "myQueue";

    private static String exchangeName = "test";

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQUtil rabbitMQUtil = new RabbitMQUtil();
        Channel channel = rabbitMQUtil.getChannel();
        // 生产消息
        for (int i = 0; i < 100000; i++) {
            channel.basicPublish(exchangeName, "", null, "hello world".getBytes());
        }
        // 创建交换机
//        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);

        // 创建队列
//        Map<String, Object> arguments = Maps.newHashMap();
//        channel.queueDeclare(queueName, true, false, false, arguments);

        // 绑定交换机和队列
//        channel.queueBind(queueName, exchangeName, "");

        // Disconnecting from RabbitMQ
        channel.close();
        rabbitMQUtil.close();
    }
}
