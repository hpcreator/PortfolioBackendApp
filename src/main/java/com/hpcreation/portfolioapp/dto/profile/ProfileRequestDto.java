package com.hpcreation.portfolioapp.dto.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequestDto {

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;

    @Size(max = 150)
    private String title;

    @Size(max = 2000)
    private String bio;

    private String profileImage;

    private String github;

    private String linkedin;

    private String twitter;
}
