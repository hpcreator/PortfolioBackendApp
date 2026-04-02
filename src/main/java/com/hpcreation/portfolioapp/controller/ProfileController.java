package com.hpcreation.portfolioapp.controller;

import com.hpcreation.portfolioapp.dto.ApiResponse;
import com.hpcreation.portfolioapp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioapp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioapp.service.ProfileService;
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
