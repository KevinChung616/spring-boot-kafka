package com.jtsp.consumeranother1.consumer;

import com.jtsp.consumeranother1.dto.ProductPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class KafkaMessageListener {

    private final Random random = new Random();
    // will automatically create dead letter topic
    @RetryableTopic(attempts = "4") // backoff and exclusion can be set here
    @KafkaListener(topics = "product", groupId = "auditing-group")
    public void consume(ProductPayload payload,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.OFFSET) long offset
    ) {
        if (random.nextBoolean()) {
            log.info("another - consumer - 1 consumes topic=[{}] the msg=[{}] with offset=[{}]",
                    topic, payload.toString(), offset);
        } else {
            log.error("another - consumer - 1 error with msg : {}", payload.toString());
            throw new RuntimeException("error consume");
        }
    }

    /**
     * method to perform retry logic for retryable topic
     */
    @DltHandler
    public void handleDeadLetterMsg(ProductPayload payload,
                                    @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                    @Header(KafkaHeaders.OFFSET) long offset
    ) {
        log.info("another - consumer - 1 - retry DLT - consumes topic=[{}] the msg=[{}] with offset=[{}]",
                topic, payload.toString(), offset);
    }
}
