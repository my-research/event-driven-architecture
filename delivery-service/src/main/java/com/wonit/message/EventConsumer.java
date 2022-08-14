package com.wonit.message;

import static io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy.ALWAYS;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventConsumer {

    @SqsListener(value = "${wonit.aws.queue-name}", deletionPolicy = ALWAYS)
    public void receive(String message) {
        log.info("메시지 수신 완료, message = " + message);
    }
}
