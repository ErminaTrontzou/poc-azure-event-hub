package com.microservices.demo.pocazureeventhub.controllers;

import com.azure.spring.messaging.eventhubs.core.EventHubsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@Slf4j
public class EventHubController {

    private final EventHubsTemplate eventHubsTemplate;
    private static final String EVENT_HUB_NAME = "poc-eventhub";

    @PostMapping("/send")
    public String sendEvent(@RequestBody String message) {
        log.info("Sending message: {}", message);
        eventHubsTemplate.send(EVENT_HUB_NAME, MessageBuilder.withPayload(message).build());
        return "Message sent: \n" + message;
    }
}
