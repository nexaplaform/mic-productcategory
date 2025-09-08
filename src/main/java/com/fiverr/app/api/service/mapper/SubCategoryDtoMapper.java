package com.fiverr.app.api.service.mapper;

import com.fiverr.app.api.service.dto.in.SubCategoryDtoIn;
import com.fiverr.app.api.service.dto.out.SubCategoryDtoOut;
import com.fiverr.app.domain.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    SubCategory toDomain(SubCategoryDtoIn dtoIn);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    SubCategoryDtoOut toDto(SubCategory model);

    List<SubCategoryDtoOut> toDtoList(List<SubCategory> domains);
}
