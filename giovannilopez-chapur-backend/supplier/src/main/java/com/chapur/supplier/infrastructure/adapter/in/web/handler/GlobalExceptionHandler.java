package com.chapur.supplier.infrastructure.adapter.in.web.handler;

import com.chapur.supplier.domain.exception.GetSupplierException;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GetSupplierException.class)
    public ResponseEntity<ErrorResponse> applicationNotFound(GetSupplierException exception){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "",
                exception.getMessage(), "");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
