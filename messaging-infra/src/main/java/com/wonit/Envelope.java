package com.wonit;

public interface Envelope<T> {
    String getId();
    T getPayload();
}
