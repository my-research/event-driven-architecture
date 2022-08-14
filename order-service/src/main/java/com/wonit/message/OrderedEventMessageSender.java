package com.wonit.message;

import com.wonit.Envelope;
import com.wonit.GeneralEnvelope;
import com.wonit.event.Ordered;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderedEventMessageSender implements MessageSender {

    public static final String SERVER_NAME = "order-service";
    private final AwsConfig awsConfig;
    private final QueueMessagingTemplate template;

    @Override
    public void send() {
        Ordered orderedEvent = Ordered.of(1L, 1L, "seoul");
        GeneralEnvelope<Ordered> envelope = GeneralEnvelope.wrap(SERVER_NAME, orderedEvent);
        template.convertAndSend(awsConfig.getQueueName(), envelope);
    }
}
