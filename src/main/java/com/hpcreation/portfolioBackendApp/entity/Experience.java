package com.hpcreation.portfolioBackendApp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Experience extends BaseEntity {

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String role;

    @Column(length = 2000)
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}
