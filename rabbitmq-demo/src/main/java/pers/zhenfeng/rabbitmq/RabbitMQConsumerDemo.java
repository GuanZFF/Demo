package pers.zhenfeng.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Grow-Worm
 * @date 2019/04/02
 */
public class RabbitMQConsumerDemo {

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQUtil rabbitMQUtil = new RabbitMQUtil();
        Channel channel = rabbitMQUtil.getChannel();
        channel.basicConsume("order", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerTag = " + consumerTag);
                System.out.println(new String(body));
                System.out.println("RabbitMQConsumerDemo.handleDelivery");
            }
        });

        System.in.read();

        channel.close();
        rabbitMQUtil.close();
    }

}
