package com.wonit.message;

import com.wonit.event.Ordered;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AwsSqsMessageSender implements MessageSender {

    private final AwsConfig awsConfig;
    private final QueueMessagingTemplate template;

    @Override
    public void send() {
        Ordered orderedEvent = Ordered.of(1L, 1L, "seoul");
        template.convertAndSend(awsConfig.getEventEnvelopeQueueName(), orderedEvent);
    }
}
