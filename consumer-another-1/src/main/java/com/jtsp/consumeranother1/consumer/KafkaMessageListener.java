package com.jtsp.consumeranother1.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {
    @KafkaListener(topics = "JTSP-demo-3", groupId = "group-2")
    public void consume(String msg) {
        log.info("another - consumer - 1 consumes the msg : {}", msg);
    }
}
