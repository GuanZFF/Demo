package pers.zhenfeng.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Grow-Worm
 * @date 2019/04/02
 */
public class RabbitMQUtil {

    private Connection connection;

    private static ConnectionFactory connectionFactory;

    static {
        // connecting to RabbitMQ
        connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHost("106.12.37.25");
        connectionFactory.setPort(5672);
    }

    public RabbitMQUtil() throws IOException, TimeoutException {
        this.connection = connectionFactory.newConnection();
    }

    public Channel getChannel() throws IOException {
        // using exchanges and queues
        return connection.createChannel();
    }

    public void close() throws IOException {
        connection.close();
    }

}
