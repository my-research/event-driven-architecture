package com.wonit.event;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value(staticConstructor = "of")
@ToString
public class KeyedEvent implements Event {

    Long key;
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
