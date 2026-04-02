package com.hpcreation.portfolioBackendApp.mapper;

import com.hpcreation.portfolioBackendApp.dto.experience.ExperienceRequestDto;
import com.hpcreation.portfolioBackendApp.dto.experience.ExperienceResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    Experience toEntity(ExperienceRequestDto dto);

    ExperienceResponseDto toDto(Experience entity);

    void updateEntity(ExperienceRequestDto dto, @MappingTarget Experience entity);
}