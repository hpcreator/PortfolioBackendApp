package com.hpcreation.portfolioapp.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import java.security.KeyPair;

@Configuration
public class JwtEncoderConfig {

    @Bean
    JwtEncoder jwtEncoder(KeyPair keyPair) {

        JWK jwk = new RSAKey.Builder((java.security.interfaces.RSAPublicKey) keyPair.getPublic())
                .privateKey((java.security.interfaces.RSAPrivateKey) keyPair.getPrivate())
                .build();

        JWKSource<SecurityContext> jwks =
                new ImmutableJWKSet<>(new JWKSet(jwk));

        return new NimbusJwtEncoder(jwks);
    }
}
