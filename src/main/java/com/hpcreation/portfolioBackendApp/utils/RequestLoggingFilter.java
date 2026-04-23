package com.hpcreation.portfolioBackendApp.utils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RequestLoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request, 1024 * 1024);

        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        long start = System.currentTimeMillis();

        filterChain.doFilter(wrappedRequest, wrappedResponse);

        long duration = System.currentTimeMillis() - start;

        logRequest(wrappedRequest);
        logResponse(wrappedResponse, duration);

        wrappedResponse.copyBodyToResponse();
    }

    private void logRequest(ContentCachingRequestWrapper request) throws IOException {

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String query = request.getQueryString();

        Map<String, String> headers = Collections.list(request.getHeaderNames()).stream().collect(Collectors.toMap(h -> h, request::getHeader));
        headers.computeIfPresent("Authorization", (k, v) -> "***");

        Map<String, String[]> params = request.getParameterMap().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> new String[]{e.getValue()[0]}));

        request.getCharacterEncoding();

        String body = new String(request.getContentAsByteArray(), request.getCharacterEncoding());

        log.info("---- HTTP_REQUEST ----> method={} uri={} query={} headers={} params={} body={} ", method, uri, query, headers, params, body);
    }

    private void logResponse(ContentCachingResponseWrapper response, long duration) {

        String body = new String(response.getContentAsByteArray(), StandardCharsets.UTF_8);
        log.info("---- HTTP_RESPONSE ----> status={} durationMs={} body={}", response.getStatus(), duration, body);
    }
}
