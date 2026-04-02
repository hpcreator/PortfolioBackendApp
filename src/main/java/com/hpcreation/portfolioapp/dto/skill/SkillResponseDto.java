package com.hpcreation.portfolioapp.dto.skill;

import com.hpcreation.portfolioapp.entity.SkillLevel;
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
