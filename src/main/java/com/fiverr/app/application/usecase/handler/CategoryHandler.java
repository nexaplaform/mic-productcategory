package com.fiverr.app.application.usecase.handler;

import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class CategoryHandler {

    private final CategoryRepository repository;

    public void addSubCategory(Category category) {

        if(Objects.nonNull(category.getSubCategory().getId())) {
            log.info("ID de consulta {}", category.getSubCategory().getId());
            Category subCategory = repository.getById(category.getSubCategory().getId());
            category.setSubCategory(subCategory);
        }
    }

}
