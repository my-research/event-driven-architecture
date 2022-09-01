package com.wonit;

import com.wonit.event.Event;
import java.util.LinkedList;
import java.util.Queue;

public class SimpleEventQueue {
    private final Queue<Event> queue = new LinkedList<>();

    public void enqueue(Event e) {
        queue.add(e);
    }

    public Event dequeue() {
        return queue.poll();
    }
}
