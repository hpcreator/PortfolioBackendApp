package com.hpcreation.portfolioapp.dto.achievement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AchievementRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 2000)
    private String description;

    private LocalDate date;

    private String imageUrl;

    private Integer displayOrder;
}
