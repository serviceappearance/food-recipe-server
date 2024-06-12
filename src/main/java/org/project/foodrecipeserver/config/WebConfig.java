package org.project.foodrecipeserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  // cors 에러 해결을 위한 class
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:8080","http://localhost:3000")
        .allowedMethods("GET", "POST","DELETE")
        .allowCredentials(true) // 쿠키 인증 요청 허용
        .maxAge(3000);
  }
}