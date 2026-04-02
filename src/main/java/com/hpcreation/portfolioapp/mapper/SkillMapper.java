package com.hpcreation.portfolioapp.mapper;

import com.hpcreation.portfolioapp.dto.skill.SkillRequestDto;
import com.hpcreation.portfolioapp.dto.skill.SkillResponseDto;
import com.hpcreation.portfolioapp.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    Skill toEntity(SkillRequestDto dto);

    SkillResponseDto toDto(Skill entity);

    void updateEntity(SkillRequestDto dto, @MappingTarget Skill entity);
}
