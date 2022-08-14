package com.wonit.message;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AwsSqsMessageSenderTest {

    @Autowired
    AwsSqsMessageSender sut;

    @Test
    void name() {
        sut.send();
    }
}