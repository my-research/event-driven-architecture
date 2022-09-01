package com.wonit.component;

import com.wonit.SimpleEventQueue;
import com.wonit.event.Event;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DownStream implements Runnable {

    private final SimpleEventQueue queue;

    @Override
    public void run() {
        Event event = queue.dequeue();

        if (event == null) {
            return;
        }
        System.out.println("event = " + event);
    }
}
