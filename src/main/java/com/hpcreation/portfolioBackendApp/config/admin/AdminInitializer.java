package com.hpcreation.portfolioBackendApp.config.admin;

import com.hpcreation.portfolioBackendApp.entity.Admin;
import com.hpcreation.portfolioBackendApp.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminProperties adminProperties;

    @Override
    public void run(String @NonNull ... args) {
        if (adminRepository.findByUsername(adminProperties.getUsername()).isPresent()) {
            return;
        }

        Admin admin = Admin.builder()
            .username(adminProperties.getUsername())
            .password(passwordEncoder.encode(adminProperties.getPassword()))
            .role(adminProperties.getRole())
            .build();

        adminRepository.save(admin);

        System.out.println("Admin user created successfully");
    }
}
