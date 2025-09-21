package com.ernesto.galarza.core.entity;

import com.ernesto.galarza.core.exception.ErrorCode;
import com.ernesto.galarza.core.exception.IErrorCode;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }


    public IErrorCode getErrorCode() { return errorCode; }

    public org.springframework.http.HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus(); // ya no hace falta instanceof
    }
}