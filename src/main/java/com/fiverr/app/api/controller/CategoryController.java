package com.fiverr.app.api.controller;

import com.fiverr.app.api.service.CategoryApi;
import com.fiverr.app.api.service.dto.in.CategoryDtoIn;
import com.fiverr.app.api.service.dto.in.SortEnumDTO;
import com.fiverr.app.api.service.dto.out.CategorytDtoOut;
import com.fiverr.app.api.service.mapper.CategoryDtoMapper;
import com.fiverr.app.application.usecase.CategoryUseCase;
import com.fiverr.app.domain.Category;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
@Tag(name = "Categories", description = "Category Administration.")
public class CategoryController implements CategoryApi {

    private final CategoryUseCase useCase;
    private final CategoryDtoMapper mapper;

    @Override
    public ResponseEntity<CategorytDtoOut> create(CategoryDtoIn dto) {
        Category category = mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDto(useCase.create(category)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategorytDtoOut> findById(Long id) {
        return new ResponseEntity<>(mapper.toDto(useCase.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategorytDtoOut> update(CategoryDtoIn dto, Long id) {
        Category category = mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDto(useCase.update(category, id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategorytDtoOut> deleteById(Long id) {
        useCase.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<CategorytDtoOut>> findAll(Integer page, Integer size, SortEnumDTO sort) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAll(page, size, sort.getValue())), HttpStatus.CREATED);
    }
}
