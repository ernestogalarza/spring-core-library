package com.ernesto.galarza.core.exception;

import java.util.List;
import java.util.Map;


public class ValidateLogicException extends BaseException{
    public ValidateLogicException(String code, String description, List<Map<String, Object>> args) {
        super(code, description, args);
    }

    public ValidateLogicException(ErrorCode errorCode) {
        super(errorCode.getCode(), ErrorCode.getDescription(errorCode));
    }

    public ValidateLogicException() {
        super(ErrorCode.INVALID_REQUEST.getCode(), ErrorCode.getDescription(ErrorCode.INVALID_REQUEST));
    }
}
