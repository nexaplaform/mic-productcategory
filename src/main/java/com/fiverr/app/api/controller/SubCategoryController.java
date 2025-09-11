package com.fiverr.app.api.controller;

import com.fiverr.app.api.service.SubCategoryApi;
import com.fiverr.app.api.service.dto.in.SubCategoryDtoIn;
import com.fiverr.app.api.service.dto.out.SubCategoryDtoOut;
import com.fiverr.app.api.service.mapper.SubCategoryDtoMapper;
import com.fiverr.app.application.usecase.SubCategoryUseCase;
import com.fiverr.app.domain.SubCategory;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/subCategories")
@Tag(name = "SubCategories", description = "SubCategory Administration.")
public class SubCategoryController implements SubCategoryApi {

    private final SubCategoryUseCase useCase;
    private final SubCategoryDtoMapper mapper;

    @Override
    public ResponseEntity<SubCategoryDtoOut> create(SubCategoryDtoIn dto) {
        SubCategory subCategory = mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDto(useCase.create(subCategory)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SubCategoryDtoOut> findById(Long id) {
        return new ResponseEntity<>(mapper.toDto(useCase.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubCategoryDtoOut> update(SubCategoryDtoIn dto, Long id) {
        SubCategory subCategory = mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDto(useCase.update(subCategory, id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        useCase.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<SubCategoryDtoOut>> findAll() {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAll()), HttpStatus.OK);
    }
}
