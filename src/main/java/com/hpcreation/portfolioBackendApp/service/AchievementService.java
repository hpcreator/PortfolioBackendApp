package com.hpcreation.portfolioBackendApp.service;


import com.hpcreation.portfolioBackendApp.dto.achievement.AchievementRequestDto;
import com.hpcreation.portfolioBackendApp.dto.achievement.AchievementResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Achievement;
import com.hpcreation.portfolioBackendApp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioBackendApp.mapper.AchievementMapper;
import com.hpcreation.portfolioBackendApp.repository.AchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementService {

    private final AchievementRepository repository;
    private final AchievementMapper mapper;


    public List<AchievementResponseDto> getAllAchievements() {

        return repository.findAllByOrderByDisplayOrderAsc().stream().map(mapper::toDto).toList();
    }

    public AchievementResponseDto createAchievement(AchievementRequestDto dto) {

        Achievement achievement = mapper.toEntity(dto);

        return mapper.toDto(repository.save(achievement));
    }

    public AchievementResponseDto updateAchievement(Long id, AchievementRequestDto dto) {

        Achievement achievement = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found with id " + id));

        mapper.updateEntity(dto, achievement);

        return mapper.toDto(repository.save(achievement));
    }

    public void deleteAchievement(Long id) {

        Achievement achievement = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found with id " + id));

        repository.delete(achievement);
    }
}