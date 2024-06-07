package com.jtsp.producer.controller;

import com.jtsp.producer.dto.ProductRequestDTO;
import com.jtsp.producer.mapper.ProductMapper;
import com.jtsp.producer.service.KafkaMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@Slf4j
public class ProductController {

    private final KafkaMessagePublisher messagePublisher;

    private final ProductMapper productMapper;

    @Autowired
    public ProductController(KafkaMessagePublisher messagePublisher, ProductMapper productMapper) {
        this.messagePublisher = messagePublisher;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequestDTO dto) {
        log.info("simulated product service -> product repo -> product DB flow {}", dto.toString());
        messagePublisher.sendProductPayload(productMapper.toProductPayload(dto));
        return ResponseEntity.ok("create product success");
    }
}
