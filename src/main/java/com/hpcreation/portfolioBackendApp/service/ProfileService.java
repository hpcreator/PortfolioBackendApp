package com.hpcreation.portfolioBackendApp.service;

import com.hpcreation.portfolioBackendApp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioBackendApp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Profile;
import com.hpcreation.portfolioBackendApp.exception.ProfileAlreadyExistsException;
import com.hpcreation.portfolioBackendApp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioBackendApp.mapper.ProfileMapper;
import com.hpcreation.portfolioBackendApp.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    //private final long SINGLETON_ID = 1;
    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    public ProfileResponseDto getProfile() {
        Profile profile = repository.findFirstByOrderByIdAsc().orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        return mapper.toDto(profile);
    }

    public ProfileResponseDto createProfile(ProfileRequestDto dto) {

        if (repository.count() == 1) {
            throw new ProfileAlreadyExistsException("Profile already exists");
        }

        Profile profile = mapper.toEntity(dto);

        return mapper.toDto(repository.save(profile));
    }

    public ProfileResponseDto updateProfile(ProfileRequestDto dto) {
        Profile profile = repository.findFirstByOrderByIdAsc().orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        mapper.updateEntity(dto, profile);

        return mapper.toDto(repository.save(profile));
    }

    public void deleteProfile() {
        if (repository.findFirstByOrderByIdAsc().isEmpty()) {
            throw new ResourceNotFoundException("Profile not found");
        }
        repository.findFirstByOrderByIdAsc().ifPresent(repository::delete);
    }
}
