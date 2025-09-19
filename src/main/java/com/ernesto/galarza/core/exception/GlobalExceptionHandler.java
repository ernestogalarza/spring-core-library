package com.ernesto.galarza.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Mono<Map<String, Object>> handleException(Exception ex, ServerWebExchange exchange) {
        HttpStatus status = ExceptionHttpStatusMapper.getStatus(ex);
        exchange.getResponse().setStatusCode(status);

        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getMessage());
        body.put("status", status.value());

        return Mono.just(body);
    }

}
