package com.jtsp.consumeranother1.consumer;

import com.jtsp.consumeranother1.dto.ProductPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {
    @KafkaListener(topics = "product", groupId = "auditing-group")
    public void consume(ProductPayload payload) {
        log.info("another - consumer - 1 consumes the msg : {}", payload.toString());
    }
}
