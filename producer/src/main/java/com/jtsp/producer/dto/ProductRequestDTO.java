package com.jtsp.producer.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductRequestDTO {
    private long id;
    private String name;
    private String company;
    private long qty;
}
