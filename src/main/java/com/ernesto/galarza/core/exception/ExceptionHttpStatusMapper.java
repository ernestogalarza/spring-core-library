package com.ernesto.galarza.core.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public enum ExceptionHttpStatusMapper {
    NULL_POINTER_EXCEPTION(NullPointerException.class, HttpStatus.BAD_REQUEST),
    ILLEGAL_ARGUMENT_EXCEPTION(IllegalArgumentException.class, HttpStatus.BAD_REQUEST),
    RUNTIME_EXCEPTION(RuntimeException.class, HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATE_EXCEPTION(ValidateLogicException.class, HttpStatus.BAD_REQUEST); // ejemplo

    private final Class<? extends Exception> exceptionClass;
    private final HttpStatus httpStatus;

    ExceptionHttpStatusMapper(Class<? extends Exception> exceptionClass, HttpStatus httpStatus) {
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Class<? extends Exception> getExceptionClass() {
        return exceptionClass;
    }

    // Método helper para obtener HttpStatus según la excepción
    public static HttpStatus getStatus(Exception ex) {
        for (ExceptionHttpStatusMapper mapper : values()) {
           // log.info(mapper.getClass().toString());
            if (mapper.getExceptionClass().isAssignableFrom(ex.getClass())) {
                return mapper.getHttpStatus();
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR; // default
    }
}
