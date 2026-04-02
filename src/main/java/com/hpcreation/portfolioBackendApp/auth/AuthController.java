package com.hpcreation.portfolioBackendApp.auth;

import com.hpcreation.portfolioBackendApp.dto.auth.LoginRequest;
import com.hpcreation.portfolioBackendApp.dto.auth.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {

        String token = authService.login(request);

        return new TokenResponse(token);
    }
}
