package com.hpcreation.portfolioBackendApp.auth;

import com.hpcreation.portfolioBackendApp.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtEncoder encoder;

    public String generateToken(String username) {

        Instant now = TimeUtils.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("portfolio-api")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(3600))
                .subject(username)
                .claim("scope", "ADMIN")
                .build();

        return encoder.encode(
                JwtEncoderParameters.from(claims)
        ).getTokenValue();
    }
}
