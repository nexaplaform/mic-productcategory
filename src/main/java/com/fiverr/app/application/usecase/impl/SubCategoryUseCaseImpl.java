package com.fiverr.app.application.usecase.impl;

import com.fiverr.app.application.usecase.SubCategoryUseCase;
import com.fiverr.app.domain.SubCategory;
import com.fiverr.app.domain.repository.SubCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SubCategoryUseCaseImpl implements SubCategoryUseCase {

    private final SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory create(SubCategory model) {
        return subCategoryRepository.create(model);
    }

    @Override
    public SubCategory getById(Long id) {
        return subCategoryRepository.getById(id);
    }

    @Override
    public SubCategory update(SubCategory model, Long id) {
        SubCategory subCategory = this.getById(id);
        BeanUtils.copyProperties(model, subCategory);
        model.setId(id);
        return subCategoryRepository.update(model);
    }

    @Override
    public List<SubCategory> findAll(Integer page, Integer size, String sort) {
        return subCategoryRepository.findAll(page, size, sort);
    }

    @Override
    public void deleteById(Long id) {
        this.getById(id);
        subCategoryRepository.deleteById(id);
    }
}
