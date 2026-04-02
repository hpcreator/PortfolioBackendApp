package com.hpcreation.portfolioapp.dto.skill;

import com.hpcreation.portfolioapp.entity.SkillLevel;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillRequestDto {

    @NotBlank(message = "Skill name is required")
    private String name;

    private SkillLevel level;

    private String icon;

    private Integer displayOrder;
}
