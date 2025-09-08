package com.fiverr.app.api.service.mapper;

import com.fiverr.app.api.service.dto.in.CategoryDtoIn;
import com.fiverr.app.api.service.dto.out.CategoryDtoOut;
import com.fiverr.app.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "subCategory", source = "parentId" , qualifiedByName = "parentIdTSubCategory")
    Category toDomain(CategoryDtoIn dtoIn);

    @Named("parentIdTSubCategory")
    default Category parentIdTSsubCategory(Long parentId) {
        if(Objects.isNull(parentId)) {
            return null;
        }

        return Category.builder()
                .id(parentId)
                .build();
    }


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    CategoryDtoOut toDto(Category model);

    List<CategoryDtoOut> toDtoList(List<Category> domains);
}
