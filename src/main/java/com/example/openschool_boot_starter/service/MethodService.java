package com.example.openschool_boot_starter.service;

import org.springframework.stereotype.Service;

@Service
public interface MethodService {
    String[][] getSolarWindPlasmaParams();

    String[][] getSolarWindMagneticParams();
}
