package com.hpcreation.portfolioapp.repository;

import com.hpcreation.portfolioapp.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findAllByOrderByStartDateDesc();
}
