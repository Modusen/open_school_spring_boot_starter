package com.example.openschool_boot_starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("openschool-boot-starter")
@Data
public class StarterProperties {
    private String user;
}
