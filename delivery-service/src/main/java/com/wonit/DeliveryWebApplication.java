package com.wonit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DeliveryWebApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DeliveryWebApplication.class, args);
    }
}
