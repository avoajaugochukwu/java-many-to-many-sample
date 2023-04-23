package com.ugo.manytomany.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

public class ValidationExceptionHandler {
    public static ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());

//        Map<String, String> errorMessages = new HashMap<>(errors);
        Map<String, String> errorMessages = new HashMap<>();
        errors.forEach((field, message) -> {
            errorMessages.put(field, message);
        });
        response.put("errors", errorMessages);

        return ResponseEntity.badRequest().body(response);
    }
}
