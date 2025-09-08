package com.fiverr.app.api.service;

import com.fiverr.app.api.service.dto.in.CategoryDtoIn;
import com.fiverr.app.api.service.dto.in.SortEnumDTO;
import com.fiverr.app.api.service.dto.out.CategoryDtoOut;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CategoryApi extends BaseApi<CategoryDtoIn, CategoryDtoOut, Long> {

    @GetMapping("/subCategories")
    @Operation(
            summary = "Get all subcategories.",
            description = "Obtain all sub-categories paginated."
    )
    default ResponseEntity<List<CategoryDtoOut>> getSubcategories(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "0") Integer size,
            @RequestParam(name = "sort", defaultValue = "0") String sort,
            @RequestParam(name = "sortDirection", defaultValue = "0") SortEnumDTO sortDirection) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
