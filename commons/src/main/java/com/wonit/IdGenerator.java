package com.wonit;

import java.time.ZonedDateTime;

public class IdGenerator {
    public static Long gen() {
        return ZonedDateTime.now().toEpochSecond();
    }
}
