package com.fiverr.app.infrastructure.db.postgres.repositories.impl;

import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.exception.EntityNotFoundException;
import com.fiverr.app.domain.repository.CategoryRepository;
import com.fiverr.app.infrastructure.db.configuration.CycleAvoidingMappingContext;
import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import com.fiverr.app.infrastructure.db.postgres.entity.SubCategoryEntity;
import com.fiverr.app.infrastructure.db.postgres.mapper.CategoryEntityMapper;
import com.fiverr.app.infrastructure.db.postgres.repositories.CategoryJpaRepository;
import com.fiverr.app.infrastructure.db.postgres.repositories.SubCategoryJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static com.fiverr.app.domain.error.Errors.NOT_FOUND_RECORD;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryEntityMapper mapper;
    private final SubCategoryJpaRepository subCategoryJpaRepository;
    private final CategoryJpaRepository repository;

    @Override
    public Category create(Category model) {
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        CategoryEntity entityMap = mapper.toEntity(model, context);

        if (Objects.nonNull(model.getSubCategories()) && !model.getSubCategories().isEmpty()) {
            List<SubCategoryEntity> subCategoryEntities = model.getSubCategories().stream()
                    .map(sub -> subCategoryJpaRepository.findById(sub.getId())
                            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_RECORD.getCode(),
                                    String.format(NOT_FOUND_RECORD.getMessage(), sub.getId())
                            )))
                    .toList();
            entityMap.setSubCategories(subCategoryEntities);
            subCategoryEntities.forEach(sub -> sub.setCategory(entityMap));
        }

        CategoryEntity entity = repository.save(entityMap);

        return mapper.toDomain(entity, context);
    }

    @Override
    public Category getById(Long id) {
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return mapper.toDomain(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(NOT_FOUND_RECORD.getCode(),
                        String.format(NOT_FOUND_RECORD.getMessage(), id))), context);
    }

    @Override
    public Category update(Category model) {
        return this.create(model);
    }

    @Override
    public List<Category> findAll() {
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return mapper.toDomainList(repository.findAll(), context);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
