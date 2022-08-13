package com.wonit;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

class GeneralEnvelopeTest {

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
        Envelope<Some> someWrapped = GeneralEnvelope.wrap(SOME);
        assertThat(someWrapped.getPayload()).isEqualTo(SOME);

        Envelope<Any> anyWrapped = GeneralEnvelope.wrap(ANY);
        assertThat(anyWrapped.getPayload()).isEqualTo(ANY);
    }

    @Test
    void unwrapping_test() {
        Envelope<Some> someWrapped = GeneralEnvelope.wrap(SOME);
        Some some = GeneralEnvelope.unwrap(someWrapped);
        assertThat(some).isEqualTo(SOME);

        Envelope<Any> anyWrapped = GeneralEnvelope.wrap(ANY);
        Any any = GeneralEnvelope.unwrap(anyWrapped);
        assertThat(any).isEqualTo(ANY);
    }
}