package com.example.openschool_boot_starter.controller;

import com.example.openschool_boot_starter.service.MethodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1/")
public class MethodController {

    @Autowired
    private MethodService methodService;

    @Operation(summary = "Receiving http request from client", tags = "receiving_methods")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful")})
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @Operation(summary = "Sending http request to get plasma solar wind params from the server", tags = "sending_methods")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful")})
    @GetMapping("/solar-plasma")
    public String[][] getSolarWindPlasmaParams() {
        return methodService.getSolarWindPlasmaParams();
    }

    @Operation(summary = "Sending http request to get magnetic solar wind params from the server", tags = "sending_methods")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful")})
    @GetMapping("/solar-magnetic")
    public String[][] getSolarWindMagneticParams() {
        return methodService.getSolarWindMagneticParams();
    }
}
