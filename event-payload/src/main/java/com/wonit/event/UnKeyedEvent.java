package com.wonit.event;

import lombok.ToString;
import lombok.Value;

@Value(staticConstructor = "of")
@ToString
public class UnKeyedEvent implements Event {

    Long key = null;
    String value;

    @Override
    public Long getKey() {
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }
}
