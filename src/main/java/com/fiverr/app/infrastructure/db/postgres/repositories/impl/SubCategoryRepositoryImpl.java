package com.fiverr.app.infrastructure.db.postgres.repositories.impl;

import com.fiverr.app.domain.SubCategory;
import com.fiverr.app.domain.exception.EntityNotFoundException;
import com.fiverr.app.domain.repository.SubCategoryRepository;
import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import com.fiverr.app.infrastructure.db.postgres.entity.SubCategoryEntity;
import com.fiverr.app.infrastructure.db.postgres.mapper.SubCategoryEntityMapper;
import com.fiverr.app.infrastructure.db.postgres.repositories.CategoryJpaRepository;
import com.fiverr.app.infrastructure.db.postgres.repositories.SubCategoryJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static com.fiverr.app.domain.error.Errors.NOT_FOUND_RECORD;

@Repository
@AllArgsConstructor
public class SubCategoryRepositoryImpl implements SubCategoryRepository {

    private final SubCategoryEntityMapper mapper;
    private final CategoryJpaRepository categoryJpaRepository;
    private final SubCategoryJpaRepository repository;

    @Override
    public SubCategory create(SubCategory model) {

        SubCategoryEntity subCategoryEntity = mapper.toEntity(model);

        if (Objects.nonNull(model) && Objects.nonNull(model.getCategory()) && Objects.nonNull(model.getCategory().getId())) {
            CategoryEntity categoryEntity = categoryJpaRepository.findById(model.getCategory().getId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            NOT_FOUND_RECORD.getCode(),
                            String.format(NOT_FOUND_RECORD.getMessage(), model.getCategory().getId())
                    ));
            subCategoryEntity.setCategory(categoryEntity);
        }

        SubCategoryEntity entity = repository.save(subCategoryEntity);
        return mapper.toDomain(entity);
    }

    @Override
    public SubCategory update(SubCategory model) {
        return this.create(model);
    }

    @Override
    public SubCategory getById(Long id) {
        SubCategoryEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_RECORD.getCode(),
                        String.format(NOT_FOUND_RECORD.getMessage(), id)));
        return mapper.toDomain(entity);
    }

    @Override
    public List<SubCategory> findAll() {
        return mapper.toDomainList(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        this.getById(id);
        repository.deleteById(id);
    }
}
