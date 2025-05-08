package com.SistemaEscolar.exceptions;


import java.time.Instant;
import java.util.List;

public record ExceptionResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        List<FieldValidationError> errors
) {}
