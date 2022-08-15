package com.wonit.event;

import lombok.Value;

@Value(staticConstructor = "of")
public class Ordered {
    Long id;
    Long itemId;
    String address;
}
