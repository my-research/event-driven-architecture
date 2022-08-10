package com.wonit;

import java.util.UUID;
import lombok.ToString;

@ToString
public class GeneralEnvelop<T> {
    String id;
    T payload;

    public static <T> GeneralEnvelop<T> wrap(T t){
        String uuid = UUID.randomUUID().toString();
        return new GeneralEnvelop<>(uuid, t);
    }

    public static <T> T unwrap(GeneralEnvelop<T> envelop) {
        return envelop.payload;
    }

    private GeneralEnvelop(String id, T payload) {
        this.id = id;
        this.payload = payload;
    }
}
