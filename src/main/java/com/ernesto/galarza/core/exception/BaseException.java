package com.ernesto.galarza.core.exception;

import java.util.List;
import java.util.Map;


public class BaseException extends RuntimeException{

    private String message;
    private String code;
    private transient Object[] args;
    private transient List<Map<String, Object>> errors;


    public BaseException(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public BaseException(String code, String message, Object[] args) {
        this.message = message;
        this.code = code;
        this.args = args;
    }

    public void setErrors(List<Map<String, Object>> errors) {
        this.errors = errors;
    }

    public BaseException(String code, String message, List<Map<String, Object>> errors) {
        this.message = message;
        this.code = code;
        this.setErrors(errors);
    }


}
