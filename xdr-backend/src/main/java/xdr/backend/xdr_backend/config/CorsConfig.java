package xdr.backend.xdr_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Allow CORS for all paths
                        .allowedOrigins("http://localhost:4200")  // Specify the allowed origin (Angular frontend)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Specify the allowed HTTP methods
                        .allowedHeaders("*")  // Allow all headers
                        .allowCredentials(true)  // Allow credentials (cookies, etc.)
                        .maxAge(3600);  // Cache the response for 1 hour
            }
        };
    }
}
