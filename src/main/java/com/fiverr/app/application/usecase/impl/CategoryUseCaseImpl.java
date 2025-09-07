package com.fiverr.app.application.usecase.impl;

import com.fiverr.app.application.usecase.CategoryUseCase;
import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryUseCaseImpl implements CategoryUseCase {

    private final CategoryRepository repository;

    @Override
    public Category create(Category model) {
        return repository.create(model);
    }

    @Override
    public Category getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Category update(Category model, Long id) {
        Category category = this.getById(id);
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
