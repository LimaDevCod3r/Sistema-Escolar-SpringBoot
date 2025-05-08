package com.SistemaEscolar.exceptions;


import java.time.Instant;
import java.util.List;

public record ExceptionResponse<T>(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        T errors
) {
}
