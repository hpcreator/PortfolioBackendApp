package com.hpcreation.portfolioBackendApp.controller;

import com.hpcreation.portfolioBackendApp.dto.api_response.ApiResponse;
import com.hpcreation.portfolioBackendApp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioBackendApp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioBackendApp.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService service;

    @GetMapping
    public ResponseEntity<ApiResponse<ProfileResponseDto>> getProfile() {
        return ResponseEntity.ok(ApiResponse.success("Profile fetched successfully", service.getProfile()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProfileResponseDto>> createProfile(@Valid @RequestBody ProfileRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Profile created successfully", service.createProfile(request)));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ProfileResponseDto>> updateProfile(@Valid @RequestBody ProfileRequestDto request) {
        return ResponseEntity.ok(ApiResponse.success("Profile updated successfully", service.updateProfile(request)));
    }
}
