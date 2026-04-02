package com.hpcreation.portfolioapp.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequestDto {

    @NotBlank(message = "Project title is required")
    private String title;

    @Size(max = 3000)
    private String description;

    private String githubUrl;

    private String liveUrl;

    private String techStack;

    private String imageUrl;

    private Integer displayOrder;
}
