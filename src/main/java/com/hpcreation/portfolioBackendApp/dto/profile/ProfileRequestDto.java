package com.hpcreation.portfolioBackendApp.dto.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    private String name;

    @Size(min = 3, max = 150)
    @NotBlank(message = "Title is required")
    private String title;

    @Size(min = 10, max = 2000)
    @NotBlank(message = "Bio is required")
    private String bio;

    private String profileImage;

    private String github;

    private String linkedin;

    private String twitter;
}
