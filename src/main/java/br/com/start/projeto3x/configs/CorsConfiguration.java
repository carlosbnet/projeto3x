package br.com.start.projeto3x.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO Auto-generated method stub

        WebMvcConfigurer.super.addCorsMappings(registry);

        registry.addMapping("/**")
        .allowedOrigins("https://arduino-message.000webhostapp.com","arduino-message.000webhostapp.com","arduino-message.000webhostapp.com/")
        .allowedMethods("POST")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");;
        

        
    }


}
