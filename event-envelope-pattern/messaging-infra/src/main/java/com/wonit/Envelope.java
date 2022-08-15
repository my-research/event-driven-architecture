package com.wonit;

public interface Envelope<T> {
    Header getHeader();
    T getPayload();
}
