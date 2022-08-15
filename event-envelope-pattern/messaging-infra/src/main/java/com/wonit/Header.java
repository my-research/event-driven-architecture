package com.wonit;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Header {
    private String id;
    private String eventType;
    private String from;

    public static Header by(String eventType, String from) {
        return new Header(UUID.randomUUID().toString(), eventType, from);
    }
}
