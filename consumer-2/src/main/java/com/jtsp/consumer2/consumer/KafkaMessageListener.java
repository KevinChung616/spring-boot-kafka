package com.jtsp.consumer2.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {
    @KafkaListener(topics = "JTSP-demo-3", groupId = "group-1")
    public void consume(String msg) {
        log.info("consumer - 2 consumes the msg : {}", msg);
    }
}
