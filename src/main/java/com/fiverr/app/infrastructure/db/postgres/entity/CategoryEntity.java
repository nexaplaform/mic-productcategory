package com.fiverr.app.infrastructure.db.postgres.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@With
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
@EqualsAndHashCode(exclude = {"subCategories"})
public class CategoryEntity {

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

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private List<SubCategoryEntity> subCategories = new ArrayList<>();

    public void addSubCategory(SubCategoryEntity subCategory) {
        subCategories.add(subCategory);
        subCategory.setCategory(this);
    }

    public void removeSubCategory(SubCategoryEntity subCategory) {
        subCategories.remove(subCategory);
        subCategory.setCategory(null);
    }
}
