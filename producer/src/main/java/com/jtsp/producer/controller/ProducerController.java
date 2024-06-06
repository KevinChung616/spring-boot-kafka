package com.jtsp.producer.controller;

import com.jtsp.producer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final KafkaMessagePublisher kafkaMessagePublisher;

    @Autowired
    public ProducerController(KafkaMessagePublisher kafkaMessagePublisher) {
        this.kafkaMessagePublisher = kafkaMessagePublisher;
    }

    @GetMapping("/publish/{msg}")
    public ResponseEntity<String> publicMsg(@PathVariable String msg) {
        kafkaMessagePublisher.sendMessageToTopic(msg);
        return ResponseEntity.ok(msg + " send success");
    }
}
