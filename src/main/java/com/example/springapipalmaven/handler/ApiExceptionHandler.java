package com.example.springapipalmaven.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springapipalmaven.dto.ApiErrorResponse;
import com.example.springapipalmaven.exception.ApiException;
import com.example.springapipalmaven.service.LogService;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final LogService logService;

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(ApiException e) {

        final ApiErrorResponse body = new ApiErrorResponse(
                e.getErrorCode(),
                e.getMessage(),
                e.getTimestamp());

        logService.gerarApiErrorLogs(body, e);

        return ResponseEntity
                .status(e.getStatus())
                .body(body);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(RuntimeException e) {

        final ApiErrorResponse body = new ApiErrorResponse(
                "UNEXPECTED_INTERNAL_RUNTIME_ERROR",
                "Erro de runtime interno inesperado",
                Instant.now());

        logService.gerarApiErrorLogs(body, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception e) {

        final ApiErrorResponse body = new ApiErrorResponse(
                "UNEXPECTED_INTERNAL_ERROR",
                "Erro interno inesperado",
                Instant.now());

        logService.gerarApiErrorLogs(body, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body);

    }

}
