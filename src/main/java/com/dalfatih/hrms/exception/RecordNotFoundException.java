package com.dalfatih.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -9079454849611061074L;
    private final String value;

    public RecordNotFoundException(String value) {
        super(String.format("Object not found with %s ", value));
        this.value = value;
    }

    public RecordNotFoundException(Throwable cause, String value) {
        super(cause);
        this.value = value;
    }
}