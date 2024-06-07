package com.jtsp.consumer2.consumer;

import com.jtsp.consumer2.dto.ProductPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {
    @KafkaListener(topics = "product", groupId = "analytic-group")
//    @KafkaListener(topics = "product", groupId = "analytic-group",
//            topicPartitions = {@TopicPartition(topic = "product", partitions = {"0, 1"})}
//    )
    public void consume(ProductPayload payload) {
        log.info("consumer - 2 consumes the msg : {}", payload.toString());
    }
}
