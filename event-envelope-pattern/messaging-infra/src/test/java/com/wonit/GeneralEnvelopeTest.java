package com.wonit;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

class GeneralEnvelopeTest {

    private static final String EVENT_TYPE = "event type";
    private static final String FROM = "any-server";
    private static final Header HEADER = Header.by(EVENT_TYPE, FROM);
    public static final Some SOME = new Some(26, "some name");
    public static final Any ANY = new Any("address", "locale");

    @Getter @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Some {
        int age;
        String name;
    }

    @Getter @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Any {
        String address;
        String locale;
    }

    @Test
    void wrapping_test() {
        Envelope<Some> someWrapped = GeneralEnvelope.wrap(HEADER, SOME);
        assertThat(someWrapped.getPayload()).isEqualTo(SOME);

        Envelope<Any> anyWrapped = GeneralEnvelope.wrap(HEADER, ANY);
        assertThat(anyWrapped.getPayload()).isEqualTo(ANY);
    }

    @Test
    void unwrapping_test() {
        Envelope<Some> someWrapped = GeneralEnvelope.wrap(HEADER, SOME);
        Some some = GeneralEnvelope.unwrap(someWrapped);
        assertThat(some).isEqualTo(SOME);

        Envelope<Any> anyWrapped = GeneralEnvelope.wrap(HEADER, ANY);
        Any any = GeneralEnvelope.unwrap(anyWrapped);
        assertThat(any).isEqualTo(ANY);
    }
}