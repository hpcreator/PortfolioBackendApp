package com.hpcreation.portfolioBackendApp.controller;

import com.hpcreation.portfolioBackendApp.dto.ApiResponse;
import com.hpcreation.portfolioBackendApp.dto.skill.SkillRequestDto;
import com.hpcreation.portfolioBackendApp.dto.skill.SkillResponseDto;
import com.hpcreation.portfolioBackendApp.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService service;

    @GetMapping
    public ApiResponse<List<SkillResponseDto>> getAllSkills() {

        return ApiResponse.<List<SkillResponseDto>>builder()
                .success(true)
                .message("Skills fetched successfully")
                .data(service.getAllSkills())
                .build();
    }

    @PostMapping
    public ApiResponse<SkillResponseDto> createSkill(
            @Valid @RequestBody SkillRequestDto request) {

        return ApiResponse.<SkillResponseDto>builder()
                .success(true)
                .message("Skill created successfully")
                .data(service.createSkill(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<SkillResponseDto> updateSkill(
            @PathVariable Long id,
            @Valid @RequestBody SkillRequestDto request) {

        return ApiResponse.<SkillResponseDto>builder()
                .success(true)
                .message("Skill updated successfully")
                .data(service.updateSkill(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteSkill(@PathVariable Long id) {

        service.deleteSkill(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Skill deleted successfully")
                .build();
    }
}