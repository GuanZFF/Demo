package pers.zhenfeng.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Grow-Worm
 * @date 2019/04/02
 */
public class RabbitMQConsumerDemo {

    private static int index = 1;

    private static long mark = System.currentTimeMillis();

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQUtil rabbitMQUtil = new RabbitMQUtil();
        Channel channel = rabbitMQUtil.getChannel();
        channel.basicQos(1000);
        channel.basicConsume("test", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                channel.basicAck(envelope.getDeliveryTag(), true);
//                System.out.println("consumerTag = " + consumerTag);
//                System.out.println(new String(body));
//                System.out.println("RabbitMQConsumerDemo.handleDelivery");
                if (index ++ == 1000) {
                    System.out.println("耗时" + (System.currentTimeMillis() - mark));
                    index = 0;
                }
            }
        });

        System.in.read();

        channel.close();
        rabbitMQUtil.close();
    }

}
