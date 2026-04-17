package com.hpcreation.portfolioBackendApp.dto.profile;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;

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

    private Instant createdDate;

    private Instant updatedDate;
}
