package com.fiverr.app.api.service.mapper;

import com.fiverr.app.api.service.dto.in.CategoryDtoIn;
import com.fiverr.app.api.service.dto.out.CategorytDtoOut;
import com.fiverr.app.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "enabled", source = "enabled")
    Category toDomain(CategoryDtoIn dtoIn);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "enabled", source = "enabled")
    CategorytDtoOut toDto(Category model);

    List<CategorytDtoOut> toDtoList(List<Category> domains);
}
