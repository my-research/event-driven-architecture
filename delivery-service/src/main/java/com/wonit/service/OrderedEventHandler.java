package com.wonit.service;

import com.rabbitmq.client.DeliverCallback;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderedEventHandler implements EventHandler {

    @Override
    public void handle(String message) {
        log.info("event received => {}", message);
    }

    @Override
    public DeliverCallback getCallback() {
        return (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            log.info("message => {}", message);
        };
    }


}
