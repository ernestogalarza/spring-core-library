package com.ernesto.galarza.core.exception;

import org.springframework.http.HttpStatus;

public interface IErrorCode {
    String getCode();
    String getDescription();
    HttpStatus getHttpStatus();
}
