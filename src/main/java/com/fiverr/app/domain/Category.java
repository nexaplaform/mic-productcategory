package com.fiverr.app.domain;

import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Long id;
    private String name;
    private String description;
    private String route;
    private Boolean enabled;
    private Category subCategory;
}
