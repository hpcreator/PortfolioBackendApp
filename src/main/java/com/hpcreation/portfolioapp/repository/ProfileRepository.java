package com.hpcreation.portfolioapp.repository;

import com.hpcreation.portfolioapp.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}