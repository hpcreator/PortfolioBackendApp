package com.hpcreation.portfolioBackendApp.controller;

import com.hpcreation.portfolioBackendApp.dto.ApiResponse;
import com.hpcreation.portfolioBackendApp.dto.achievement.AchievementRequestDto;
import com.hpcreation.portfolioBackendApp.dto.achievement.AchievementResponseDto;
import com.hpcreation.portfolioBackendApp.service.AchievementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService service;

    @GetMapping
    public ApiResponse<List<AchievementResponseDto>> getAllAchievements() {

        return ApiResponse.<List<AchievementResponseDto>>builder().success(true).message("Achievements fetched successfully").data(service.getAllAchievements()).build();
    }

    @PostMapping
    public ApiResponse<AchievementResponseDto> createAchievement(@Valid @RequestBody AchievementRequestDto request) {

        return ApiResponse.<AchievementResponseDto>builder().success(true).message("Achievement created successfully").data(service.createAchievement(request)).build();
    }

    @PutMapping("/{id}")
    public ApiResponse<AchievementResponseDto> updateAchievement(@PathVariable Long id, @Valid @RequestBody AchievementRequestDto request) {

        return ApiResponse.<AchievementResponseDto>builder().success(true).message("Achievement updated successfully").data(service.updateAchievement(id, request)).build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteAchievement(@PathVariable Long id) {

        service.deleteAchievement(id);

        return ApiResponse.<Void>builder().success(true).message("Achievement deleted successfully").build();
    }
}