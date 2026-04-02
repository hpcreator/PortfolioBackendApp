package com.hpcreation.portfolioBackendApp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpcreation.portfolioBackendApp.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull AuthenticationException ex) {

        try {

            ErrorResponse error = ErrorResponse.builder().timestamp(Instant.now()).status(401).error("Unauthorized").message("JWT token missing or invalid").path(request.getRequestURI()).build();

            response.setStatus(401);
            response.setContentType("application/json");

            new ObjectMapper().writeValue(response.getOutputStream(), error);

        } catch (Exception ignored) {
        }
    }
}
