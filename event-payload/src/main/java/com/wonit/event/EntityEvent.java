package com.wonit.event;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@ToString
@Value(staticConstructor = "of")
public class EntityEvent implements Event{

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
