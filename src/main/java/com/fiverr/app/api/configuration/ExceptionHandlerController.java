package com.fiverr.app.api.configuration;

import com.fiverr.app.api.service.dto.out.ErrorResponse;
import com.fiverr.app.domain.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFoundHandlerException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(List.of())
                .timeStamp(ZonedDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }
}
