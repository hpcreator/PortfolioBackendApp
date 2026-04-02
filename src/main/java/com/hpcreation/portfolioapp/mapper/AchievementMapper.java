package com.hpcreation.portfolioapp.mapper;

import com.hpcreation.portfolioapp.dto.achievement.AchievementRequestDto;
import com.hpcreation.portfolioapp.dto.achievement.AchievementResponseDto;
import com.hpcreation.portfolioapp.entity.Achievement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    Achievement toEntity(AchievementRequestDto dto);

    AchievementResponseDto toDto(Achievement entity);

    void updateEntity(AchievementRequestDto dto, @MappingTarget Achievement entity);
}
