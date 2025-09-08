package com.fiverr.app.api.service.mapper;

import com.fiverr.app.api.service.dto.in.CategoryDtoIn;
import com.fiverr.app.api.service.dto.out.CategoryDtoOut;
import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "subCategories", source = "subCategoryIds", qualifiedByName = "subCategoryIdsToSubCategories")
    Category toDomain(CategoryDtoIn dtoIn);

    @Named("subCategoryIdsToSubCategories")
    default List<SubCategory> subCategoryIdsToSubCategories(List<Long> ids) {
        if(Objects.isNull(ids) || ids.isEmpty()) {
            return Collections.emptyList();
        }

        return ids.stream().map( id -> SubCategory.builder()
                .id(id)
                .build()).toList();
    }

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "subCategories", source = "subCategories")
    CategoryDtoOut toDto(Category model);

    List<CategoryDtoOut> toDtoList(List<Category> domains);
}
