package com.fiverr.app.infrastructure.db.postgres.mapper;

import com.fiverr.app.domain.Category;
import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    Category toDomain(CategoryEntity entity);

    CategoryEntity toEntity(Category model);

    List<Category> toDomainList(List<CategoryEntity> entities);
}
