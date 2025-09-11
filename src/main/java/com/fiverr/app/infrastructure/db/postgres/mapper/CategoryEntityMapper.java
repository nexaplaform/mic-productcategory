package com.fiverr.app.infrastructure.db.postgres.mapper;

import com.fiverr.app.domain.Category;
import com.fiverr.app.infrastructure.db.configuration.CycleAvoidingMappingContext;
import com.fiverr.app.infrastructure.db.configuration.SharedMapperConfig;
import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import org.mapstruct.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = SharedMapperConfig.class, builder = @Builder(disableBuilder = true))
public interface CategoryEntityMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "subCategories", source = "subCategories")
    Category toDomain(CategoryEntity entity, @Context CycleAvoidingMappingContext context);


    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "subCategories", source = "subCategories")
    CategoryEntity toEntity(Category model, @Context CycleAvoidingMappingContext context);

    List<Category> toDomainList(List<CategoryEntity> entities, @Context CycleAvoidingMappingContext context);
}
