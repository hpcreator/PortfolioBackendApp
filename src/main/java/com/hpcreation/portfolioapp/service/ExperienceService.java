package com.hpcreation.portfolioapp.service;

import com.hpcreation.portfolioapp.dto.experience.ExperienceRequestDto;
import com.hpcreation.portfolioapp.dto.experience.ExperienceResponseDto;
import com.hpcreation.portfolioapp.entity.Experience;
import com.hpcreation.portfolioapp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioapp.mapper.ExperienceMapper;
import com.hpcreation.portfolioapp.repository.ExperienceRepository;
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
