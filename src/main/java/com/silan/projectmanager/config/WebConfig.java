package com.silan.projectmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(@NonNull CorsRegistry registry) {
    registry.addMapping("/**") // Adjust the path as needed
        .allowedOrigins("http://localhost:4200") // Allow your frontend origin
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed methods
        .allowedHeaders("*") // Allow any headers
        .exposedHeaders("Auth-token", "Auth-sessionId")
        .allowCredentials(true); // Allow credentials if needed
  }
}
