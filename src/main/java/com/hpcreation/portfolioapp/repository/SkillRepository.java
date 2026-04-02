package com.hpcreation.portfolioapp.repository;

import com.hpcreation.portfolioapp.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findAllByOrderByDisplayOrderAsc();
}