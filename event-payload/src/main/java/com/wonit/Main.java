package com.wonit;

import com.wonit.component.DownStream;
import com.wonit.component.UpStream;

public class Main {
    public static void main(String[] args) {
        SimpleEventQueue queue = new SimpleEventQueue();

        DownStream stream = new DownStream(queue);

        Thread t = new Thread(stream);
        t.start();
    }
}
