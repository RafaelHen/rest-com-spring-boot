package com.projeto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().info(new Info().title("RESTFul API com Java 18")
										.version("v1")
										.description("")
										.termsOfService("")
										.license(
												new License()
												.name("Apache 2.0")
												.url("")
												));
	}
	
	

}
