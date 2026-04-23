package com.hpcreation.portfolioBackendApp.dto.profile;

import java.time.LocalDateTime;

public record ProfileResponseDto(
    Long id,
    String name,
    String title,
    String bio,
    String profileImage,
    String github,
    String linkedin,
    String twitter,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
