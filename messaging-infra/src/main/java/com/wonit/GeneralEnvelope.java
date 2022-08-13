package com.wonit;

import java.util.UUID;
import lombok.ToString;

@ToString
public class GeneralEnvelope<T> implements Envelope<T>{
    private final String id;
    private final T payload;

    // TODO Validation Check
    public static <T> GeneralEnvelope<T> wrap(T t){
        String uuid = UUID.randomUUID().toString();
        return new GeneralEnvelope<>(uuid, t);
    }

    public static <T> T unwrap(Envelope<T> envelop) {
        return envelop.getPayload();
    }

    private GeneralEnvelope(String id, T payload) {
        this.id = id;
        this.payload = payload;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public T getPayload() {
        return payload;
    }
}
