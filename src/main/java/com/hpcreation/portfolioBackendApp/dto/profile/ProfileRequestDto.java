package com.hpcreation.portfolioBackendApp.dto.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfileRequestDto(
    @NotBlank(message = "Name is required") @Size(min = 2, max = 100) String name,

    @Size(min = 3, max = 150) @NotBlank(message = "Title is required") String title,

    @Size(min = 10, max = 2000) @NotBlank(message = "Bio is required") String bio,

    String profileImage,

    String github,

    String linkedin,

    String twitter) {
}
