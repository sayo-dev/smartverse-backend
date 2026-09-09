package org.smartvert.smartvert.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.smartvert.smartvert.model.dto.ApiResponse;
import org.smartvert.smartvert.model.dto.ApplianceDTO;
import org.smartvert.smartvert.service.ApplianceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ApplianceService applianceService;

    @PostMapping(value = "/appliances", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ApplianceDTO>> createAppliance(
            @Valid @RequestPart("dto") ApplianceDTO dto,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        ApplianceDTO created = applianceService.createAppliance(dto, file);
        return ResponseEntity.ok(ApiResponse.success("Appliance created successfully", created));
    }

    @PutMapping(value = "/appliances/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ApplianceDTO>> updateAppliance(
            @PathVariable UUID id,
            @Valid @RequestPart("dto") ApplianceDTO dto,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        ApplianceDTO updated = applianceService.updateAppliance(id, dto, file);
        return ResponseEntity.ok(ApiResponse.success("Appliance updated successfully", updated));
    }

    @PatchMapping("/appliances/{id}/status")
    public ResponseEntity<ApiResponse<ApplianceDTO>> updateStatus(
            @PathVariable UUID id,
            @RequestParam("active") boolean active) {
        ApplianceDTO updated = applianceService.updateApplianceStatus(id, active);
        return ResponseEntity.ok(ApiResponse.success("Appliance status updated successfully", updated));
    }
}
