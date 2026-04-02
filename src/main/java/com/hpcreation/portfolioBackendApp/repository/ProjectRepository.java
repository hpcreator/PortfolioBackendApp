package com.hpcreation.portfolioBackendApp.repository;

import com.hpcreation.portfolioBackendApp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByOrderByDisplayOrderAsc();
}