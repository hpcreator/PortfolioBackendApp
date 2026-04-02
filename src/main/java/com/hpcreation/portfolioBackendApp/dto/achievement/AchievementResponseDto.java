package com.hpcreation.portfolioBackendApp.dto.achievement;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class AchievementResponseDto {

    private Long id;

    private String title;

    private String description;

    private LocalDate date;

    private String imageUrl;

    private Integer displayOrder;
}
