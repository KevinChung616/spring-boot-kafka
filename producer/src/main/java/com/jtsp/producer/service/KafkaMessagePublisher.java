package com.jtsp.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaMessagePublisher {

    private final KafkaTemplate<String, Object> template;

    @Autowired
    public KafkaMessagePublisher(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    public void sendMessageToTopic(String msg) {
        CompletableFuture<SendResult<String, Object>> future = template.send("lea-seydoux", msg);
        // future.get() will block
        future.whenComplete((res, err) -> {
           if (Objects.isNull(err)) {
               log.info("send message=[{}] with offset=[{}]", msg, res.getRecordMetadata().offset());
           } else {
               log.error("Unable to send message=[{}] due to: {}", msg, err.getMessage());
           }
        });
    }
}
