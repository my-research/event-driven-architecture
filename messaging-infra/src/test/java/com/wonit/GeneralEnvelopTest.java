package com.wonit;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

class GeneralEnvelopTest {

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
        GeneralEnvelop<Some> someWrapped = GeneralEnvelop.wrap(SOME);
        assertThat(someWrapped.payload).isEqualTo(SOME);

        GeneralEnvelop<Any> anyWrapped = GeneralEnvelop.wrap(ANY);
        assertThat(anyWrapped.payload).isEqualTo(ANY);
    }

    @Test
    void unwrapping_test() {
        GeneralEnvelop<Some> someWrapped = GeneralEnvelop.wrap(SOME);
        Some some = GeneralEnvelop.unwrap(someWrapped);
        assertThat(some).isEqualTo(SOME);

        GeneralEnvelop<Any> anyWrapped = GeneralEnvelop.wrap(ANY);
        Any any = GeneralEnvelop.unwrap(anyWrapped);
        assertThat(any).isEqualTo(ANY);
    }
}