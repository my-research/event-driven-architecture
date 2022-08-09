package com.wonit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wonit.event.Ordered;
import com.wonit.util.Serializer;
import java.nio.charset.StandardCharsets;

public class Producer {

    private static final String QUEUE_NAME = "ORDERED";

    public void produce() throws Exception {
        ConnectionFactory factory = getConnectionFactory();

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            Ordered orderedEvent = Ordered.of(1L, 2L, "seoul");
            String serialized = Serializer.getInstance().serialize(orderedEvent);
            channel.basicPublish("", QUEUE_NAME, null, serialized.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + serialized + "'");
        }
    }

    private ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("rabbitpassword");
        return factory;
    }
}
