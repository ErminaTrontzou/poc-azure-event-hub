package com.microservices.demo.pocazureeventhub.services;

import com.azure.spring.messaging.eventhubs.implementation.core.annotation.EventHubsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final String EVENT_HUB_NAME = "poc-eventhub";
    private static final String CONSUMER_GROUP = "$DEFAULT";

    @EventHubsListener(destination = EVENT_HUB_NAME, group = CONSUMER_GROUP)
    public void handleMessageFromEventHub(String message) {
        System.out.printf("New message received: %s%n", message);
    }
}
