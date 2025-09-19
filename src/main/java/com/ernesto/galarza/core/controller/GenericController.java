package com.ernesto.galarza.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GenericController {
    @GetMapping("/core/hello")
    public Mono<String> hello() {
        return Mono.just("Hello from core-library!");
    }
}
