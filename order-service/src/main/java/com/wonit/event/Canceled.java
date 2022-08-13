package com.wonit.event;

import lombok.Value;

@Value(staticConstructor = "of")
public class Canceled {
    Long id;
    Long orderId;
    String reason;
}
