package com.dalfatih.hrms.exception;

import lombok.Data;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
//@RequiredArgsConstructor
public class ErrorResponse {

    @NonNull
    private final HttpStatus status;

    @NonNull
    private final String message;

    @NonNull
    private List<String> details;

}