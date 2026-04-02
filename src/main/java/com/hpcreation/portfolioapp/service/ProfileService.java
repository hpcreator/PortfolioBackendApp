package com.hpcreation.portfolioapp.service;

import com.hpcreation.portfolioapp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioapp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioapp.entity.Profile;
import com.hpcreation.portfolioapp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioapp.mapper.ProfileMapper;
import com.hpcreation.portfolioapp.repository.ProfileRepository;
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
