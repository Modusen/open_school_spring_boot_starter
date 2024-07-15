package com.example.openschool_boot_starter.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("openschool-boot-starter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarterProperties {
    private String user;
}
