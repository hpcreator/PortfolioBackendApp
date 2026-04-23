package com.hpcreation.portfolioBackendApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String password;

    private String role;
}
