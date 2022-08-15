package com.wonit;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class GeneralEnvelope<T> implements Envelope<T> {
    private Header header;
    private T payload;

    // TODO Validation Check
    public static <T> GeneralEnvelope<T> wrap(Header header, T t) {
        return new GeneralEnvelope<>(header, t);
    }

    public static <T> T unwrap(Envelope<T> envelop) {
        return envelop.getPayload();
    }

    private GeneralEnvelope(Header header, T payload) {
        this.header = header;
        this.payload = payload;
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public T getPayload() {
        return payload;
    }
}
