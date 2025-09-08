package com.fiverr.app.application.usecase.impl;

import com.fiverr.app.application.usecase.CategoryUseCase;
import com.fiverr.app.application.usecase.handler.SubCategoryHandler;
import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryUseCaseImpl implements CategoryUseCase {

    private final CategoryRepository repository;
    private final SubCategoryHandler subCategoryHandler;

    @Override
    public Category create(Category model) {
        subCategoryHandler.addSubCategories(model);
        return repository.create(model);
    }

    @Override
    public Category getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Category update(Category model, Long id) {
        Category category = this.getById(id);
        subCategoryHandler.addSubCategories(model);
        BeanUtils.copyProperties(model, category, "id");
        return repository.update(category);
    }

    @Override
    public List<Category> findAll(Integer page, Integer size, String sort) {
        return repository.findAll(page, size, sort);
    }

    @Override
    public void deleteById(Long id) {
        this.getById(id);
        repository.deleteById(id);
    }
}
