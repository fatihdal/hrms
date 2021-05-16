package com.dalfatih.hrms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ErrorResponse {

    @NonNull
    private final HttpStatus status;

    @NonNull
    private final String message;

    @NonNull
    private List<String> details;

   /* public ErrorResponse(HttpStatus status, String message, List<String> details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }

    public HttpStatus getStatus() {
        return status;
    }*/
}