package com.hpcreation.portfolioBackendApp.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtEncoder encoder;

    public String generateToken(String username) {

        Instant now = Instant.now().truncatedTo(ChronoUnit.MILLIS);

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
