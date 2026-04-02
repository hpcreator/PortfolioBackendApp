package com.hpcreation.portfolioBackendApp.dto.project;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectResponseDto {

    private Long id;

    private String title;

    private String description;

    private String githubUrl;

    private String liveUrl;

    private String techStack;

    private String imageUrl;

    private Integer displayOrder;
}