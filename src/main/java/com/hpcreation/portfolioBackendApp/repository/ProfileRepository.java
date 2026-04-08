package com.hpcreation.portfolioBackendApp.repository;

import com.hpcreation.portfolioBackendApp.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findBySingletonKey(int singletonKey);

    boolean existsBySingletonKey(int singletonKey);
}
