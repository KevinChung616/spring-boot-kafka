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

    /**
     * Send message to topic which has 3 partitions
     */
    @GetMapping("/publish-2/{msg}")
    public ResponseEntity<String> publicToAnotherTopic(@PathVariable String msg) {
        for (int i = 0; i < 1000; i++) {
            kafkaMessagePublisher.sendMessageToTopicWithManyPartitions("msg " + i);
        }
        return ResponseEntity.ok(msg + " send success");
    }

    @GetMapping("/publish-3/{msg}")
    public ResponseEntity<String> publicToThirdTopic(@PathVariable String msg) {
        for (int i = 0; i < 100; i++) {
            kafkaMessagePublisher.sendMessageToThirdTopic("msg " + i);
        }
        return ResponseEntity.ok(msg + " send success");
    }
}
