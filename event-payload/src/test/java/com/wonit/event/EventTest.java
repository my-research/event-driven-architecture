package com.wonit.event;

import com.wonit.IdGenerator;
import com.wonit.Serializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

class EventTest {

    @Data
    @AllArgsConstructor
    static class Foo {
        String userId;
    }

    @Test
    void name() {
        Foo foo = new Foo("39124");
        String body = Serializer.toJson(foo);
        Event event = EntityEvent.of(IdGenerator.gen(), body);

        System.out.println("event = " + event);
    }

    @Test
    void name1() {
        Foo foo = new Foo("39124");
        String body = Serializer.toJson(foo);
        Event event = KeyedEvent.of(IdGenerator.gen(), body);

        System.out.println("event = " + event);
    }

    @Test
    void name2() {
        Foo foo = new Foo("39124");
        String body = Serializer.toJson(foo);
        Event event = UnKeyedEvent.of(body);

        System.out.println("event = " + event);
    }
}