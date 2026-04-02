package com.hpcreation.portfolioBackendApp.mapper;

import com.hpcreation.portfolioBackendApp.dto.project.ProjectRequestDto;
import com.hpcreation.portfolioBackendApp.dto.project.ProjectResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toEntity(ProjectRequestDto dto);

    ProjectResponseDto toDto(Project entity);

    void updateEntity(ProjectRequestDto dto, @MappingTarget Project entity);
}