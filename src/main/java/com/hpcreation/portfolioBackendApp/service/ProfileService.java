package com.hpcreation.portfolioBackendApp.service;

import com.hpcreation.portfolioBackendApp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioBackendApp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Profile;
import com.hpcreation.portfolioBackendApp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioBackendApp.mapper.ProfileMapper;
import com.hpcreation.portfolioBackendApp.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    public ProfileResponseDto getProfile() {
        Profile profile = repository.findAll().stream().findFirst().orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        return mapper.toDto(profile);
    }

    public ProfileResponseDto updateProfile(ProfileRequestDto dto) {
        Profile profile = repository.findAll().stream().findFirst().orElse(new Profile());

        mapper.updateEntity(dto, profile);

        return mapper.toDto(repository.save(profile));
    }
}
