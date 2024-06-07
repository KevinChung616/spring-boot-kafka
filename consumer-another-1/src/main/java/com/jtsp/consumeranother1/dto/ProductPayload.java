package com.jtsp.consumeranother1.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductPayload {
    private long id;
    private String name;
    private String company;
    private long qty;
}
