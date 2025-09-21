package com.ernesto.galarza.core.controller;

import com.ernesto.galarza.core.entity.ApiException;
import com.ernesto.galarza.core.exception.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GenericController {
    @GetMapping("/core")
    public Mono<String> hello() {
        throw new ApiException(ErrorCode.NOT_FOUND);
    }
}
