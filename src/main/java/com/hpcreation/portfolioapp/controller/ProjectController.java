package com.hpcreation.portfolioapp.controller;

import com.hpcreation.portfolioapp.dto.ApiResponse;
import com.hpcreation.portfolioapp.dto.project.ProjectRequestDto;
import com.hpcreation.portfolioapp.dto.project.ProjectResponseDto;
import com.hpcreation.portfolioapp.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @GetMapping
    public ApiResponse<List<ProjectResponseDto>> getAllProjects() {

        return ApiResponse.<List<ProjectResponseDto>>builder().success(true).message("Projects fetched successfully").data(service.getAllProjects()).build();
    }

    @PostMapping
    public ApiResponse<ProjectResponseDto> createProject(@Valid @RequestBody ProjectRequestDto request) {

        return ApiResponse.<ProjectResponseDto>builder().success(true).message("Project created successfully").data(service.createProject(request)).build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ProjectResponseDto> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectRequestDto request) {

        return ApiResponse.<ProjectResponseDto>builder().success(true).message("Project updated successfully").data(service.updateProject(id, request)).build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProject(@PathVariable Long id) {

        service.deleteProject(id);

        return ApiResponse.<Void>builder().success(true).message("Project deleted successfully").build();
    }
}