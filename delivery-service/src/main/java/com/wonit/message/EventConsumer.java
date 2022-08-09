package com.wonit.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.wonit.service.EventHandler;
import com.wonit.service.OrderedEventHandler;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventConsumer {
    private static final String QUEUE_HOST = "localhost";
    private static final String QUEUE_USERNAME = "admin";
    private static final String QUEUE_PASSWORD = "rabbitpassword";

    private static final String QUEUE_NAME = "ORDERED";



    public void consume() {
        ConnectionFactory factory = getConnectionFactory();
        try (Channel channel = getChannel(factory.newConnection())) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            log.info("Event Consuming 하는 중...");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                final EventHandler eventHandler = new OrderedEventHandler();
                eventHandler.handle(message);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private Channel getChannel(Connection connection) throws IOException {
        return connection.createChannel();
    }

    private ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(QUEUE_HOST);
        factory.setUsername(QUEUE_USERNAME);
        factory.setPassword(QUEUE_PASSWORD);
        return factory;
    }
}
