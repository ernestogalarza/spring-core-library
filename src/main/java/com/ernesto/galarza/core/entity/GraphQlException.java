package com.ernesto.galarza.core.entity;

import java.time.Instant;

public class GraphQlException {

    private String code;
    private String message;
    private Instant timestamp;
    private String path;

    public GraphQlException(String code, String message, String path) {
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now();
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }
}