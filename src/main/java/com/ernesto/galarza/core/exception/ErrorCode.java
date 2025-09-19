package com.ernesto.galarza.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Map;

import static java.util.Map.entry;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    GENERAL_001("EGE001"),
    INVALID_REQUEST("EGR001"),
    NOT_FOUND("EGF001");

    private final String code;

    static final Map<ErrorCode, String> MAP_DESCRIPTION = Map.ofEntries(
            entry(GENERAL_001, "Error general. Please contact with administrator."),
            entry(INVALID_REQUEST, "Invalid Request.Please review your payload"),
            entry(NOT_FOUND, "Resource not available."));


    @Nullable
    public static String getDescription(ErrorCode code) {
        return MAP_DESCRIPTION.get(code);
    }


}
