package com.fiverr.app.infrastructure.db.postgres.mapper;

import com.fiverr.app.domain.Category;
import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "subCategory", source = "parent")
    Category toDomain(CategoryEntity entity);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "parent", source = "subCategory")
    CategoryEntity toEntity(Category model);

    List<Category> toDomainList(List<CategoryEntity> entities);
}
