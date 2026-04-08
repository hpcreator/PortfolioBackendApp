package com.hpcreation.portfolioBackendApp.dto.api_response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private int status;

    private String code;

    private String message;

    private String path;

    private List<String> details;
}
