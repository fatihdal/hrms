package com.dalfatih.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CitizenNotVerifiedException extends RuntimeException{

    private static final long serialVersionUID = -9079454849611061074L;
    private final String value;

    public CitizenNotVerifiedException(String value) {
        super(String.format("Citizen information could not be verified %s ", value));
        this.value = value;
    }

    public CitizenNotVerifiedException(Throwable cause, String value) {
        super(cause);
        this.value = value;
    }
}
