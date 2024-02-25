package com.projeto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Value("${cors.originPatterns:default}")
	private String corsOriginPatters = "";

	@Override //Habilitando CORS de forma global
	public void addCorsMappings(CorsRegistry registry) {
		var allowedOrigins = corsOriginPatters.split(",");
		registry.addMapping("/**")
//		.allowedMethods("GET","PUT","POST")
		.allowedMethods("*")
		.allowedOrigins(allowedOrigins)
		.allowCredentials(true);
	}
	
	
	
	
}
