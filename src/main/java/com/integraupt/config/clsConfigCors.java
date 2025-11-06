package com.integraupt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * Configuración global de CORS para Render + Netlify
 * Sin necesidad de Spring Security
 */
@Configuration
public class clsConfigCors {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        // 🔹 Dominios permitidos
        config.setAllowedOriginPatterns(List.of(
            "http://localhost:5173",   // desarrollo local
            "http://localhost:3000",
            "https://intregraupt.netlify.app" // dominio de producción
        ));

        // 🔹 Permitir todo tipo de cabeceras y métodos HTTP
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // 🔹 Registrar configuración para todas las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
