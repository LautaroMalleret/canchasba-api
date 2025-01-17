package com.app.CANCHASBA_API;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configurar CORS para todos los endpoints
        registry.addMapping("/**")  // Permite acceso a todos los endpoints de la API
                .allowedOrigins("http://localhost:4200")  // Origen desde el que se permiten solicitudes (en tu caso, el frontend Angular)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
                .allowedHeaders("*")  // Permite todos los encabezados
                .allowCredentials(true);  // Si necesitas enviar credenciales (como cookies)
    }
}
