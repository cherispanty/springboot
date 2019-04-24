package com.example.ticketprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务提供者注册时到zookeeper
 *
 */
@SpringBootApplication
public class TicketProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketProviderApplication.class, args);
    }

}
