package com.example.openschool_boot_starter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class MethodServiceImpl implements MethodService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL_PLASMA_5_MIN = "https://services.swpc.noaa.gov/text/rtsw/data/plasma-6-hour-5-minute.json";
    private final String URL_MAGNETIC_5_MIN = "https://services.swpc.noaa.gov/text/rtsw/data/mag-6-hour-5-minute.json";

    @Override
    public String[][] getSolarWindPlasmaParams() {
        ResponseEntity<String[][]> response = restTemplate.getForEntity(URL_PLASMA_5_MIN, String[][].class);
        return response.getBody();
    }
    @Override
    public String[][] getSolarWindMagneticParams() {
        ResponseEntity<String[][]> response = restTemplate.getForEntity(URL_MAGNETIC_5_MIN, String[][].class);
        return response.getBody();
    }

}
