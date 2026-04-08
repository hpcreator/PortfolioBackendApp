package com.hpcreation.portfolioBackendApp.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpcreation.portfolioBackendApp.dto.api_response.ApiError;
import com.hpcreation.portfolioBackendApp.dto.api_response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull AuthenticationException ex) {

        try {
            ApiError error = ApiError.builder().status(HttpServletResponse.SC_UNAUTHORIZED).message("Unauthorized").path(request.getRequestURI()).details(List.of("JWT token missing or invalid")).build();
            ApiResponse<Void> apiResponse = ApiResponse.failure("Authentication failed", error);

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } catch (Exception e) {
            // fallback in case serialization fails
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
