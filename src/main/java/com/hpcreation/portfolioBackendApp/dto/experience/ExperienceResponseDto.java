package com.hpcreation.portfolioBackendApp.dto.experience;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ExperienceResponseDto {

    private Long id;

    private String company;

    private String role;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}