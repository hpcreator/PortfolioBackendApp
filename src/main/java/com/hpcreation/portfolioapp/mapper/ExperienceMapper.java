package com.hpcreation.portfolioapp.mapper;

import com.hpcreation.portfolioapp.dto.experience.ExperienceRequestDto;
import com.hpcreation.portfolioapp.dto.experience.ExperienceResponseDto;
import com.hpcreation.portfolioapp.entity.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    Experience toEntity(ExperienceRequestDto dto);

    ExperienceResponseDto toDto(Experience entity);

    void updateEntity(ExperienceRequestDto dto, @MappingTarget Experience entity);
}