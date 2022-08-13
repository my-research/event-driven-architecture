package com.wonit.message;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private final CountDownLatch latch = new CountDownLatch(1);

    public void receive(String message) {
        System.out.println(message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
