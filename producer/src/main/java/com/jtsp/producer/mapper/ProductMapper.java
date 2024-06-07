package com.jtsp.producer.mapper;

import com.jtsp.producer.dto.ProductPayload;
import com.jtsp.producer.dto.ProductRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public  ProductPayload toProductPayload(ProductRequestDTO requestDTO) {
        return ProductPayload.builder()
                .id(requestDTO.getId())
                .company(requestDTO.getCompany())
                .name(requestDTO.getName())
                .qty(requestDTO.getQty())
                .build();
    }
}
