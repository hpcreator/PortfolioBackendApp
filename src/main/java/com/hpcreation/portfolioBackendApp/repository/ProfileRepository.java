package com.hpcreation.portfolioBackendApp.repository;

import com.hpcreation.portfolioBackendApp.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}