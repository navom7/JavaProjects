package com.navom.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "nanhe-kafka-topic", groupId = "nanhe-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        // Process the received message
    }
}
