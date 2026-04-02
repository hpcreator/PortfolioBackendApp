package com.hpcreation.portfolioBackendApp.dto.experience;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExperienceRequestDto {

    @NotBlank(message = "Company name is required")
    private String company;

    @NotBlank(message = "Role is required")
    private String role;

    @Size(max = 2000)
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}
