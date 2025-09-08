package com.fiverr.app.domain.error;

import lombok.Getter;

@Getter
public enum Errors {

    NOT_FOUND_RECORD("ENF001", "El registro con id %s, no ha sido encontrado.");

    private String code;
    private String message;

    Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
