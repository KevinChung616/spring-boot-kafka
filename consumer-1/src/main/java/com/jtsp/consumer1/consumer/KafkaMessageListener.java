package com.jtsp.consumer1.consumer;

import com.jtsp.consumer1.dto.ProductPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "product", groupId = "analytic-group")
    public void consume(ProductPayload payload) {
        log.info("consumer - 1 consumes the msg : {}", payload.toString());
    }
}
