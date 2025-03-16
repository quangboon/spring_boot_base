package com.example.phong.demo.config;

import org.springdoc.core.configuration.SpringDocDataRestConfiguration;
import org.springdoc.core.models.GroupedOpenApi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringDocDataRestConfiguration.class)
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Demo API")
                        .version("1.0")
                        .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .packagesToScan("com.example.phong.demo.controller")
                .build();
    }
}