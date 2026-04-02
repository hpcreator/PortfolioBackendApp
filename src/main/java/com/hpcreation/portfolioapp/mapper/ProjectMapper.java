package com.hpcreation.portfolioapp.mapper;

import com.hpcreation.portfolioapp.dto.project.ProjectRequestDto;
import com.hpcreation.portfolioapp.dto.project.ProjectResponseDto;
import com.hpcreation.portfolioapp.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toEntity(ProjectRequestDto dto);

    ProjectResponseDto toDto(Project entity);

    void updateEntity(ProjectRequestDto dto, @MappingTarget Project entity);
}