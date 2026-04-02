package com.hpcreation.portfolioBackendApp.auth;

import com.hpcreation.portfolioBackendApp.dto.auth.LoginRequest;
import com.hpcreation.portfolioBackendApp.entity.Admin;
import com.hpcreation.portfolioBackendApp.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String login(LoginRequest request) {

        Admin admin = adminRepository.findByUsername(request.username()).orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), admin.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(admin.getUsername());
    }
}
