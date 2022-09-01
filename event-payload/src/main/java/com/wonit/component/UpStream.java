package com.wonit.component;

import com.wonit.SimpleEventQueue;
import com.wonit.event.Event;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpStream implements Runnable {

    private final SimpleEventQueue queue;

    @Override
    public void run() {

    }
}
