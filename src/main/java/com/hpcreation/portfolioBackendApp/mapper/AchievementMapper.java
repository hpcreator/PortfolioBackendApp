package com.hpcreation.portfolioBackendApp.mapper;

import com.hpcreation.portfolioBackendApp.dto.achievement.AchievementRequestDto;
import com.hpcreation.portfolioBackendApp.dto.achievement.AchievementResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Achievement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    Achievement toEntity(AchievementRequestDto dto);

    AchievementResponseDto toDto(Achievement entity);

    void updateEntity(AchievementRequestDto dto, @MappingTarget Achievement entity);
}
