package com.example.openschool_boot_starter.config;

import com.example.openschool_boot_starter.interceptor.HttpRequestInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StarterProperties.class)
public class OpenschoolAutoconfiguration {
    @Bean
    public HttpRequestInterceptor httpRequestInterceptor(StarterProperties props) {
        return new HttpRequestInterceptor(props);
    }

    ;
}
