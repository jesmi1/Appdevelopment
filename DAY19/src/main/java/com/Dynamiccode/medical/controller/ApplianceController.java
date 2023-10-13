package com.Dynamiccode.medical.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dynamiccode.medical.constant.Api;
import com.Dynamiccode.medical.dto.request.ApplianceRequest;
import com.Dynamiccode.medical.service.ApplianceService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.APPLIANCE)
@RequiredArgsConstructor
@Tag(name = "Appliance")
public class ApplianceController {

    private final ApplianceService applianceService;

    @PostMapping("/save")
    public ResponseEntity<String> saveAppliance(@RequestBody ApplianceRequest request) {
        boolean isSaved = applianceService.saveAppliance(request);
        return isSaved ? ResponseEntity.status(200).body("Appliance saved successfully!")
                : ResponseEntity.badRequest().build();
    }
}
