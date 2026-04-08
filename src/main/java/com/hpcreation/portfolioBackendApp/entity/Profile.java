package com.hpcreation.portfolioBackendApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profiles", uniqueConstraints = {@UniqueConstraint(name = "unique_single_profile", columnNames = "singleton_key")})
public class Profile extends BaseEntity {
    @Column(name = "singleton_key", nullable = false, updatable = false)
    private int singletonKey = 1;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String bio;

    private String profileImage;

    private String github;

    private String linkedin;

    private String twitter;
}
