package com.fiverr.app.domain;


import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    private Long id;
    private String date;
    private String client;
    private String description;
    private Double cost;
    private String duration;
}
