package com.todeb.rsakin.coursemanagementapplication.exception.handler;

import com.todeb.rsakin.coursemanagementapplication.exception.CustomJwtException;
import com.todeb.rsakin.coursemanagementapplication.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(EntityNotFoundException exception) {
        Map<String, String> errorResponseMap = new HashMap<>();
        errorResponseMap.put("error_message", exception.getMessage());
        errorResponseMap.put("error_details", exception.getDetails());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseMap);
    }

    @ExceptionHandler(CustomJwtException.class)
    public ResponseEntity<Map<String, String>> handleCustomJwtException(CustomJwtException exception) {
        Map<String, String> errorResponseMap = new HashMap<>();
        errorResponseMap.put("error_message", exception.getMessage());
        errorResponseMap.put("error_status", exception.getHttpStatus().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseMap);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(Exception exception) {
        Map<String, String> errorResponseMap = new HashMap<>();
        errorResponseMap.put("error_message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseMap);
    }

}
