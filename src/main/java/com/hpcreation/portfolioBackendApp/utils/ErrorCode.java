package com.hpcreation.portfolioBackendApp.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, "Profile not found"),
    PROFILE_ALREADY_EXISTS(HttpStatus.CONFLICT, "Profile already exists"),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "Invalid credentials"),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "Validation failed"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected server error"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Authentication failed");

    private final HttpStatus status;
    private final String message;
}
