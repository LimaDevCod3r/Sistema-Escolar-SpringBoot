package com.SistemaEscolar.exceptions;

public record FieldValidationError(
        String field,
        String message
) {}
