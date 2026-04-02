package com.hpcreation.portfolioapp.service;

import com.hpcreation.portfolioapp.dto.skill.SkillRequestDto;
import com.hpcreation.portfolioapp.dto.skill.SkillResponseDto;
import com.hpcreation.portfolioapp.entity.Skill;
import com.hpcreation.portfolioapp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioapp.mapper.SkillMapper;
import com.hpcreation.portfolioapp.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository repository;
    private final SkillMapper mapper;

    public List<SkillResponseDto> getAllSkills() {

        return repository.findAllByOrderByDisplayOrderAsc().stream().map(mapper::toDto).toList();
    }

    public SkillResponseDto createSkill(SkillRequestDto dto) {

        Skill skill = mapper.toEntity(dto);

        return mapper.toDto(repository.save(skill));
    }

    public SkillResponseDto updateSkill(Long id, SkillRequestDto dto) {

        Skill skill = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill not found with id " + id));

        mapper.updateEntity(dto, skill);

        return mapper.toDto(repository.save(skill));
    }

    public void deleteSkill(Long id) {

        Skill skill = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill not found with id " + id));

        repository.delete(skill);
    }
}
