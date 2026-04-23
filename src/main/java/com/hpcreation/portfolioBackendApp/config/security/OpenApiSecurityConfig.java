package com.hpcreation.portfolioBackendApp.config.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiSecurityConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        final var tags = List.of(
            new Tag().name("auth-controller"),
            new Tag().name("profile-controller"),
            new Tag().name("project-controller"),
            new Tag().name("skill-controller"),
            new Tag().name("experience-controller"),
            new Tag().name("achievement-controller")
        );

        return new OpenAPI()
            .addSecurityItem(
                new SecurityRequirement()
                    .addList(securitySchemeName))
            .components(
                new Components()
                    .addSecuritySchemes(securitySchemeName,
                        new SecurityScheme()
                            .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )
            ).tags(tags);
    }
}
