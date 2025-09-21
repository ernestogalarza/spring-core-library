package com.ernesto.galarza.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.util.Map;

import static java.util.Map.entry;


public enum ErrorCode implements IErrorCode {
    GENERAL_001("EGE001", HttpStatus.INTERNAL_SERVER_ERROR, "General error. Please contact admin."),
    INVALID_REQUEST("EGR001", HttpStatus.BAD_REQUEST, "Invalid request. Review payload."),
    NOT_FOUND("EGF001", HttpStatus.NOT_FOUND, "Resource not found.");

    private final String code;
    private final HttpStatus httpStatus;
    private final String description;

    ErrorCode(String code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }

    @Override
    public String getCode() { return code; }

    @Override
    public String getDescription() { return description; }

    @Override
    public HttpStatus getHttpStatus() { return httpStatus; }
}
