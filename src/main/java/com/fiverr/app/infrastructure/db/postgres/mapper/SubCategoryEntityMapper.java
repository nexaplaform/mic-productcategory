package com.fiverr.app.infrastructure.db.postgres.mapper;

import com.fiverr.app.domain.SubCategory;
import com.fiverr.app.infrastructure.db.postgres.entity.SubCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryEntityMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    SubCategory toDomain(SubCategoryEntity entity);


    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "route", source = "route")
    @Mapping(target = "enabled", source = "enabled")
    SubCategoryEntity toEntity(SubCategory model);

    List<SubCategory> toDomainList(List<SubCategoryEntity> entities);
}
