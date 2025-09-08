package com.fiverr.app.infrastructure.db.postgres.entity;

import jakarta.persistence.*;
import lombok.*;

@With
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subcategories")
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "route")
    private String route;

    @Column(name = "enabled")
    private Boolean enabled;
}
