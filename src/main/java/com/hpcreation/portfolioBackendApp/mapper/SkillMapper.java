package com.hpcreation.portfolioBackendApp.mapper;

import com.hpcreation.portfolioBackendApp.dto.skill.SkillRequestDto;
import com.hpcreation.portfolioBackendApp.dto.skill.SkillResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    Skill toEntity(SkillRequestDto dto);

    SkillResponseDto toDto(Skill entity);

    void updateEntity(SkillRequestDto dto, @MappingTarget Skill entity);
}
