package com.wonit.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderedEventHandler implements EventHandler {

    @Override
    public void handle(String message) {
        log.info("event received => {}", message);
    }
}
