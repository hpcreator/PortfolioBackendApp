package com.hpcreation.portfolioapp.service;


import com.hpcreation.portfolioapp.dto.achievement.AchievementRequestDto;
import com.hpcreation.portfolioapp.dto.achievement.AchievementResponseDto;
import com.hpcreation.portfolioapp.entity.Achievement;
import com.hpcreation.portfolioapp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioapp.mapper.AchievementMapper;
import com.hpcreation.portfolioapp.repository.AchievementRepository;
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