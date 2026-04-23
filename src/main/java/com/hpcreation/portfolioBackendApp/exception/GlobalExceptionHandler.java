package com.hpcreation.portfolioBackendApp.exception;

import com.hpcreation.portfolioBackendApp.dto.api_response.ApiError;
import com.hpcreation.portfolioBackendApp.dto.api_response.ApiResponse;
import com.hpcreation.portfolioBackendApp.utils.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidCredentials(
        InvalidCredentialsException ex,
        HttpServletRequest request) {

        ErrorCode code = ErrorCode.INVALID_CREDENTIALS;

        ApiError error = ApiError.builder()
            .status(code.getStatus().value())
            .code(code.name())
            .message(code.getMessage())
            .path(request.getRequestURI())
            .details(List.of(ex.getMessage()))
            .build();

        return ResponseEntity.status(code.getStatus())
            .body(ApiResponse.failure(code.getMessage(), error));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(
        ResourceNotFoundException ex,
        HttpServletRequest request) {

        ErrorCode code = ErrorCode.PROFILE_NOT_FOUND;

        ApiError error = ApiError.builder()
            .status(code.getStatus().value())
            .code(code.name())
            .message(code.getMessage())
            .path(request.getRequestURI())
            .build();

        return ResponseEntity.status(code.getStatus())
            .body(ApiResponse.failure(code.getMessage(), error));
    }

    @ExceptionHandler(ProfileAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleProfileExists(
        ProfileAlreadyExistsException ex,
        HttpServletRequest request) {

        ErrorCode code = ErrorCode.PROFILE_ALREADY_EXISTS;

        ApiError error = ApiError.builder()
            .status(code.getStatus().value())
            .code(code.name())
            .message(code.getMessage())
            .path(request.getRequestURI())
            .build();

        return ResponseEntity.status(code.getStatus())
            .body(ApiResponse.failure(code.getMessage(), error));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(
        MethodArgumentNotValidException ex,
        HttpServletRequest request) {

        List<String> details = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .toList();

        ErrorCode code = ErrorCode.VALIDATION_ERROR;

        ApiError error = ApiError.builder()
            .status(code.getStatus().value())
            .code(code.name())
            .message(code.getMessage())
            .path(request.getRequestURI())
            .details(details)
            .build();

        return ResponseEntity.status(code.getStatus())
            .body(ApiResponse.failure(code.getMessage(), error));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneral(
        Exception ex,
        HttpServletRequest request) {

        ErrorCode code = ErrorCode.INTERNAL_SERVER_ERROR;

        ApiError error = ApiError.builder()
            .status(code.getStatus().value())
            .code(code.name())
            .message(code.getMessage())
            .path(request.getRequestURI())
            .build();

        return ResponseEntity.status(code.getStatus())
            .body(ApiResponse.failure(code.getMessage(), error));
    }
}
