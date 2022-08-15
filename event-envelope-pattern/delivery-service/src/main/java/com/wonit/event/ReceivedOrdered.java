package com.wonit.event;

import lombok.Value;

@Value(staticConstructor = "of")
public class ReceivedOrdered {
    Long id;
    Long itemId;
    String address;
}
