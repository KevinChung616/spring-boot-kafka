package com.jtsp.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    private static final Integer PARTITION_NUMBER = 5;
    private static final Short REPLICATION_FACTOR = (short) 1;

    private static final String TOPIC_NAME = "JTSP-demo-3";

    private static final String TOPIC_NAME_PRODUCT = "product";

    private static final Integer PARTITION_NUMBER_PRODUCT = 3;


    /**
     * Tell Spring topic we want to create topic
     *
     */

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(TOPIC_NAME, PARTITION_NUMBER, REPLICATION_FACTOR);
    }

    @Bean
    public NewTopic createProductTopic() {
        return new NewTopic(TOPIC_NAME_PRODUCT, PARTITION_NUMBER_PRODUCT, REPLICATION_FACTOR);
    }

}
