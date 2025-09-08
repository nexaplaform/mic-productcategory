package com.fiverr.app.application.usecase.handler;

import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.SubCategory;
import com.fiverr.app.domain.repository.SubCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class SubCategoryHandler {

    private final SubCategoryRepository subCategoryRepository;

    public void addSubCategories(Category model) {

        if (Objects.isNull(model.getSubCategories()) || model.getSubCategories().isEmpty()) {
            return;
        }

        List<SubCategory> subCategories = model.getSubCategories().stream().map(c -> {
            return subCategoryRepository.getById(c.getId());
        }).toList();

        model.setSubCategories(subCategories);
    }
}
