package com.hpcreation.portfolioapp.auth;

import com.hpcreation.portfolioapp.dto.auth.LoginRequest;
import com.hpcreation.portfolioapp.dto.auth.TokenResponse;
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
