package com.fiverr.app.api.service.mapper;

import com.fiverr.app.api.service.dto.in.SubCategoryDtoIn;
import com.fiverr.app.api.service.dto.out.SubCategoryDtoOut;
import com.fiverr.app.domain.Category;
import com.fiverr.app.domain.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface SubCategoryDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategoryIdToCategory")
    SubCategory toDomain(SubCategoryDtoIn dtoIn);

    @Named("mapCategoryIdToCategory")
    default Category mapCategoryIdToCategory(Long categoryId) {

        if (Objects.isNull(categoryId)) {
            return null;
        }

        return Category.builder()
                .id(categoryId)
                .build();
    }

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "categoryId", source = "category", qualifiedByName = "mapCategoryToCategoryId")
    SubCategoryDtoOut toDto(SubCategory model);

    @Named("mapCategoryToCategoryId")
    default Long mapCategoryToCategoryId(Category category) {
        if (Objects.isNull(category) || Objects.isNull(category.getId())) {
            return null;
        }
        return category.getId();
    }
    
    List<SubCategoryDtoOut> toDtoList(List<SubCategory> domains);
}
