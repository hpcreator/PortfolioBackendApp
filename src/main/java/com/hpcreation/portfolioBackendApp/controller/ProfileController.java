package com.hpcreation.portfolioBackendApp.controller;

import com.hpcreation.portfolioBackendApp.dto.ApiResponse;
import com.hpcreation.portfolioBackendApp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioBackendApp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioBackendApp.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService service;

    @GetMapping
    public ApiResponse<ProfileResponseDto> getProfile() {

        return ApiResponse.<ProfileResponseDto>builder()
                .success(true)
                .message("Profile fetched successfully")
                .data(service.getProfile())
                .build();
    }

    @PutMapping
    public ApiResponse<ProfileResponseDto> updateProfile(
            @Valid @RequestBody ProfileRequestDto request) {

        return ApiResponse.<ProfileResponseDto>builder()
                .success(true)
                .message("Profile updated successfully")
                .data(service.updateProfile(request))
                .build();
    }
}
