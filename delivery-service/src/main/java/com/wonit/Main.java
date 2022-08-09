package com.wonit;

import com.wonit.message.EventConsumer;

public class Main {

    public static void main(String[] args) {
        EventConsumer consumer = new EventConsumer();

        consumer.consume();
    }
}
