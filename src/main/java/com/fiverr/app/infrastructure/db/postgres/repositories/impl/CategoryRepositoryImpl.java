package com.fiverr.app.infrastructure.db.postgres.repositories.impl;

import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.exception.EntityNotFoundException;
import com.fiverr.app.domain.repository.CategoryRepository;
import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import com.fiverr.app.infrastructure.db.postgres.mapper.CategoryEntityMapper;
import com.fiverr.app.infrastructure.db.postgres.repositories.CategoryRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fiverr.app.domain.error.Errors.NOT_FOUND_RECORD;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryEntityMapper mapper;
    private final CategoryRepositoryAdapter repository;

    @Override
    public Category create(Category model) {
        CategoryEntity entity = repository.save(mapper.toEntity(model));
        return mapper.toDomain(entity);
    }

    @Override
    public Category getById(Long id) {
        return mapper.toDomain(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(NOT_FOUND_RECORD.getCode(),
                        String.format(NOT_FOUND_RECORD.getMessage(), id))));
    }

    @Override
    public Category update(Category model) {
       return this.create(model);
    }

    @Override
    public List<Category> findAll(Integer page, Integer size, String sort) {
        String sortProperty = "id";
        Sort.Direction direction = Sort.Direction.fromString(sort);
        Sort sortObject = Sort.by(direction, sortProperty);
        Pageable pageable = PageRequest.of(page, size, sortObject);
        Page<CategoryEntity> userEntity = repository.findAll(pageable);
        return mapper.toDomainList(userEntity.getContent());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
