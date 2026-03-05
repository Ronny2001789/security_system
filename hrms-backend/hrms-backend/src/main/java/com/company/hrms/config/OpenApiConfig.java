package com.company.hrms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;



@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "HRMS API",
                version = "1.0",
                description = "HR Management System API Documentation"
        )
)
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server()
                        .url("http://13.50.4.2:8081")
                        .description("AWS Server"))
                .addServersItem(new Server()
                        .url("https://hrms-backend-68043500996.us-central1.run.app")
                        .description("Google Cloud Server"))
                .addServersItem(new Server()
                        .url("https://hrms-backend.mangowave-746513ba.eastus.azurecontainerapps.io")
                        .description("Azure Server"))
                .addServersItem(new Server()
                        .url("http://localhost:8081")
                        .description("Local Server"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearerAuth"));
    }
}

