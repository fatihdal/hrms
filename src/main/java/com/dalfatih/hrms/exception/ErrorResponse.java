package com.dalfatih.hrms.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorResponse {

    @NonNull
    private final HttpStatus status;

    @NonNull
    private final String message;

    private List<String> details;
}