package com.vin.BankingApplication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Add your frontend origin(s) here
                .allowedMethods("GET", "POST") // Add allowed HTTP methods
                .allowedHeaders("*"); // Allow credentials
    }
}
