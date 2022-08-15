package com.wonit.message;

import com.wonit.GeneralEnvelope;
import com.wonit.Header;
import com.wonit.event.Ordered;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderedEventMessageSender implements MessageSender {

    private static final String EVENT_TYPE = "ORDERED";
    public static final String SERVER_NAME = "order-service";
    private final AwsConfig awsConfig;
    private final QueueMessagingTemplate template;

    @Override
    public void send() {
        Ordered payload = Ordered.of(1L, 1L, "seoul");
        Header header = Header.by(EVENT_TYPE, SERVER_NAME);
        GeneralEnvelope<Ordered> envelope = GeneralEnvelope.wrap(header, payload);
        template.convertAndSend(awsConfig.getQueueName(), envelope);
    }
}
