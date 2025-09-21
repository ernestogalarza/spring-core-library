package com.ernesto.galarza.core.exception;

import com.ernesto.galarza.core.entity.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja ApiException lanzadas por core o proyectos hijos
    @ExceptionHandler(ApiException.class)
    public Mono<ResponseEntity<Map<String, Object>>> handleApiException(ApiException ex) {
        IErrorCode errorCode = ex.getErrorCode();

        Map<String, Object> body = Map.of(
                "code", errorCode.getCode(),
                "message", errorCode.getDescription()
        );

        return Mono.just(ResponseEntity.status(errorCode.getHttpStatus()).body(body));
    }

    // Maneja cualquier otra excepción no controlada
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<Map<String, Object>>> handleGenericException(Exception ex) {
        Map<String, Object> body = Map.of(
                "code", ErrorCode.GENERAL_001.getCode(),
                "message", "Unexpected error: " + ex.getMessage()
        );

        return Mono.just(ResponseEntity.status(ErrorCode.GENERAL_001.getHttpStatus()).body(body));
    }
}