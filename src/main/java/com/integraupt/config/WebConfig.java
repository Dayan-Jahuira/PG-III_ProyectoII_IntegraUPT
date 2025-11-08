package com.integraupt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Fallback para CORS en caso de que el CorsFilter no se aplique (Render/Tomcat)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(
                "http://localhost:5173",
                "http://localhost:3000",
                "https://intregraupt.netlify.app"
            )
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
