package com.suplier.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.suplier.DTO.ApiResponse;

@RestControllerAdvice
public class GlobalException {

    // Handle MethodArgumentNotValidException for validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // Map to hold field errors
        Map<String, String> errors = new HashMap<>();

        // Loop through all validation errors
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // Extract field name and error message
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            // Add field name and message to the response map
            errors.put(fieldName, errorMessage);
        });

        // Return the response with BAD_REQUEST status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Handle ResourceNotFoundException for resource not found errors
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        // Create an ApiResponse object with the error message
        ApiResponse response = new ApiResponse(ex.getMessage(), false);
        
        // Return the response with NOT_FOUND status
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
