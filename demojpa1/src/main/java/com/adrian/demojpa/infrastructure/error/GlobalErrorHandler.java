package com.adrian.demojpa.infrastructure.error;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.adrian.demojpa.infrastructure.error.model.FieldError;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRunTimeException(RuntimeException e){
        return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage(), "StatusCode", HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(RolDuplicateException.class)
    public ResponseEntity<?> handleRolDuplicateException(RolDuplicateException e){
        return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage(), "StatusCode", e.getStatus().value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleFieldsException(MethodArgumentNotValidException e){
        List<FieldError> FieldErrors = e.getFieldErrors().stream().map(field -> new FieldError(field.getField(), field.getDefaultMessage()))
        .toList();
        return ResponseEntity.badRequest().body(FieldErrors);
    }
}
