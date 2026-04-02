package com.hpcreation.portfolioBackendApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profile extends BaseEntity {
    @Column(nullable = false)
    @NotBlank
    private String name;

    private String title;

    @Column(length = 2000)
    private String bio;

    private String profileImage;

    private String github;

    private String linkedin;

    private String twitter;
}