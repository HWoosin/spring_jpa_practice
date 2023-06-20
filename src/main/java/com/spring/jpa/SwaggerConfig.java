package com.spring.jpa;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI custiomOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Spring Boot Board API Example")
                                .description("Spring Boot Board API예시 프로젝트입니다.")
                                .version("v1.0.0")
                        );
    }
}
