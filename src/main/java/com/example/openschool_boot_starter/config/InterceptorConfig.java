package com.example.openschool_boot_starter.config;

import com.example.openschool_boot_starter.interceptor.HttpRequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
@EnableConfigurationProperties(StarterProperties.class)
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final StarterProperties props;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpRequestInterceptor(props))
                .addPathPatterns("/api/v1/**")
                .excludePathPatterns("/swagger-ui/**");
    }
}
