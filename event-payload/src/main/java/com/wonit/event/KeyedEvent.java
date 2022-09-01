package com.wonit.event;

import lombok.ToString;
import lombok.Value;

@Value(staticConstructor = "of")
@ToString
public class KeyedEvent implements Event {

    Long key;
    String value;

    @Override
    public Long getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
