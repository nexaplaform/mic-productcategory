package com.fiverr.app.infrastructure.db.postgres.mapper;

import com.fiverr.app.domain.SubCategory;
import com.fiverr.app.infrastructure.db.postgres.entity.SubCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryEntityMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "category.id", source = "category.id")
    @Mapping(target = "category.name", ignore = true)
    @Mapping(target = "category.description", ignore = true)
    @Mapping(target = "category.route", ignore = true)
    @Mapping(target = "category.enabled", ignore = true)
    @Mapping(target = "category.subCategories", ignore = true)
    SubCategory toDomain(SubCategoryEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "category", ignore = true)
    SubCategoryEntity toEntity(SubCategory model);

    List<SubCategory> toDomainList(List<SubCategoryEntity> entities);
}
