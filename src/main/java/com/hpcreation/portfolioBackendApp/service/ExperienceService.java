package com.hpcreation.portfolioBackendApp.service;

import com.hpcreation.portfolioBackendApp.dto.experience.ExperienceRequestDto;
import com.hpcreation.portfolioBackendApp.dto.experience.ExperienceResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Experience;
import com.hpcreation.portfolioBackendApp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioBackendApp.mapper.ExperienceMapper;
import com.hpcreation.portfolioBackendApp.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository repository;
    private final ExperienceMapper mapper;

    public List<ExperienceResponseDto> getAllExperiences() {
        return repository.findAllByOrderByStartDateDesc().stream().map(mapper::toDto).toList();
    }

    public ExperienceResponseDto createExperience(ExperienceRequestDto dto) {

        Experience experience = mapper.toEntity(dto);

        return mapper.toDto(repository.save(experience));
    }

    public ExperienceResponseDto updateExperience(Long id, ExperienceRequestDto dto) {

        Experience experience = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience not found with id " + id));

        mapper.updateEntity(dto, experience);

        return mapper.toDto(repository.save(experience));
    }

    public void deleteExperience(Long id) {

        Experience experience = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience not found with id " + id));
        repository.delete(experience);
    }
}
