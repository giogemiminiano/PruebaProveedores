package com.chapur.supplier.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI creditApplicationApi(){
        return new OpenAPI().info(new Info().title("Gestión de proveedores")
                .description("Api para la gestión de proveedores chapur.")
                .version("1.0.0")).externalDocs(
                        new ExternalDocumentation().description("Respositorio")
                                .url("https://github.com/giogemiminiano/PruebaProveedores"));
    }
}
