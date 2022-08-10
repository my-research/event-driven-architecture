package com.wonit;

import com.wonit.message.EventConsumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        EventConsumer consumer = new EventConsumer();
        consumer.consume();
    }

}
