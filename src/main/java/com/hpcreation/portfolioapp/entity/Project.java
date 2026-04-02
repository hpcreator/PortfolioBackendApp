package com.hpcreation.portfolioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(length = 3000)
    private String description;

    private String githubUrl;

    private String liveUrl;

    private String techStack;

    private String imageUrl;

    private Integer displayOrder;
}
