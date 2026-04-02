package com.hpcreation.portfolioapp.service;


import com.hpcreation.portfolioapp.dto.project.ProjectRequestDto;
import com.hpcreation.portfolioapp.dto.project.ProjectResponseDto;
import com.hpcreation.portfolioapp.entity.Project;
import com.hpcreation.portfolioapp.exception.ResourceNotFoundException;
import com.hpcreation.portfolioapp.mapper.ProjectMapper;
import com.hpcreation.portfolioapp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapper mapper;


    public List<ProjectResponseDto> getAllProjects() {
        return repository.findAllByOrderByDisplayOrderAsc().stream().map(mapper::toDto).toList();
    }

    public ProjectResponseDto createProject(ProjectRequestDto dto) {
        Project project = mapper.toEntity(dto);
        return mapper.toDto(repository.save(project));
    }

    public ProjectResponseDto updateProject(Long id, ProjectRequestDto dto) {
        Project project = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        mapper.updateEntity(dto, project);

        return mapper.toDto(repository.save(project));
    }

    public void deleteProject(Long id) {

        repository.deleteById(id);
    }
}
