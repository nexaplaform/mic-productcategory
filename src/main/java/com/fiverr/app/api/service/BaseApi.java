package com.fiverr.app.api.service;

import com.fiverr.app.api.service.dto.in.SortEnumDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseApi<I, O, K> {

    @PostMapping
    default ResponseEntity<O> create(@Valid @RequestBody I dto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/id")
    default ResponseEntity<O> findById(@PathVariable K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/id")
    default ResponseEntity<O> update(@Valid @RequestBody I dto, Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/id")
    default ResponseEntity<O> deleteById(@PathVariable K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping
    default ResponseEntity<List<O>> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size,
            @RequestParam(defaultValue = "ASC") SortEnumDTO sort
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
