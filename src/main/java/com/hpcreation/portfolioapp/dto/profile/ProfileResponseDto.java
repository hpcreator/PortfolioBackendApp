package com.hpcreation.portfolioapp.dto.profile;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfileResponseDto {

    private Long id;

    private String name;

    private String title;

    private String bio;

    private String profileImage;

    private String github;

    private String linkedin;

    private String twitter;
}
