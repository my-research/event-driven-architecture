package com.wonit.service;

import com.rabbitmq.client.DeliverCallback;

public interface EventHandler {
    void handle(String event);
    DeliverCallback getCallback();
}
