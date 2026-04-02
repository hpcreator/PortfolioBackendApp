package com.hpcreation.portfolioBackendApp.dto.skill;

import com.hpcreation.portfolioBackendApp.entity.SkillLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SkillResponseDto {

    private Long id;

    private String name;

    private SkillLevel level;

    private String icon;

    private Integer displayOrder;
}
