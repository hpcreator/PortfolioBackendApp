package com.hpcreation.portfolioBackendApp.controller;

import com.hpcreation.portfolioBackendApp.dto.ApiResponse;
import com.hpcreation.portfolioBackendApp.dto.experience.ExperienceRequestDto;
import com.hpcreation.portfolioBackendApp.dto.experience.ExperienceResponseDto;
import com.hpcreation.portfolioBackendApp.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService service;

    @GetMapping
    public ApiResponse<List<ExperienceResponseDto>> getAllExperiences() {

        return ApiResponse.<List<ExperienceResponseDto>>builder().success(true).message("Experiences fetched successfully").data(service.getAllExperiences()).build();
    }

    @PostMapping
    public ApiResponse<ExperienceResponseDto> createExperience(@Valid @RequestBody ExperienceRequestDto request) {

        return ApiResponse.<ExperienceResponseDto>builder().success(true).message("Experience created successfully").data(service.createExperience(request)).build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ExperienceResponseDto> updateExperience(@PathVariable Long id, @Valid @RequestBody ExperienceRequestDto request) {

        return ApiResponse.<ExperienceResponseDto>builder().success(true).message("Experience updated successfully").data(service.updateExperience(id, request)).build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteExperience(@PathVariable Long id) {

        service.deleteExperience(id);

        return ApiResponse.<Void>builder().success(true).message("Experience deleted successfully").build();
    }
}
