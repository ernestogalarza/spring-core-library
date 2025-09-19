package com.ernesto.galarza.core.controller;

import com.ernesto.galarza.core.exception.ValidateLogicException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GenericController {
    @GetMapping("/core")
    public Mono<String> hello() {
        throw new ValidateLogicException();

       // return Mono.just("Hello from core-library!");
    }
}
