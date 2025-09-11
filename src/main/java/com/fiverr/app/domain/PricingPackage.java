package com.fiverr.app.domain;

import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricingPackage {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer deliveryTimeInDays;
    private Integer revisions;
}
