package com.ryu.studyhelper.common.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ryu.studyhelper.common.dto.ApiResponse;
import com.ryu.studyhelper.common.enums.CustomResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiResponse<?>> handleIOException(IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.createError(CustomResponseStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.createError(CustomResponseStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodNotSupported(
            HttpRequestMethodNotSupportedException ex) {
        Map<String, Object> data = new HashMap<>();
        data.put("supportedMethods", ex.getSupportedMethods());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(ApiResponse.createError(CustomResponseStatus.METHOD_NOT_ALLOWED, data));
    }

    // CustomException 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<?>> handleCustomException(CustomException e) {
        CustomResponseStatus status = e.getStatus();
        return ResponseEntity.status(status.getHttpStatusCode()).body(ApiResponse.createError(status));
    }
}