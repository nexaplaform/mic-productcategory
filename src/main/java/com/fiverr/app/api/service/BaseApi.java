package com.fiverr.app.api.service;

import com.fiverr.app.api.service.dto.in.SortEnumDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseApi<I, O, K> {

    @PostMapping
    @Operation(
            summary = "Create record",
            description = "Creation of record")
    default ResponseEntity<O> create(@Valid @RequestBody I dto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping({"/{id}"})
    @Operation(
            summary = "Get record by id",
            description = "Search a record by id")
    default ResponseEntity<O> findById(@PathVariable K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update record",
            description = "Update a record by id")
    default ResponseEntity<O> update(@Valid @RequestBody I dto, K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping({"/{id}"})
    @Operation(
            summary = "Delete record",
            description = "Delete a record by id")
    default ResponseEntity<Void> deleteById(@PathVariable K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping
    @Operation(
            summary = "Get paginated records",
            description = "Get a number of paginated records")
    default ResponseEntity<List<O>> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size,
            @RequestParam(defaultValue = "ASC") SortEnumDTO sort) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
