package pers.zhenfeng.rabbitmq;

import com.google.common.collect.Maps;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Grow-Worm
 * @date 2019/04/02
 */
public class RabbitMQProducerDemo {

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQUtil rabbitMQUtil = new RabbitMQUtil();
        Channel channel = rabbitMQUtil.getChannel();
//        channel.basicPublish("test", "", null, "hello world".getBytes());
        Map<String, Object> arguments = Maps.newHashMap();
        arguments.put("orderId", "123");
        channel.queueDeclare("order", true, false, false, arguments);

        System.in.read();

        // Disconnecting from RabbitMQ
        channel.close();
        rabbitMQUtil.close();
    }

}
