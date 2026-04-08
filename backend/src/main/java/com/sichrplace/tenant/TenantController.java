package com.sichrplace.tenant;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.tenant.dto.TenantProfileRequest;
import com.sichrplace.tenant.dto.TenantProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenant")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('TENANT')")
    public ResponseEntity<ApiResponse<String>> getDashboard() {
        return ResponseEntity.ok(tenantService.getDashboard(null));
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('TENANT')")
    public ResponseEntity<ApiResponse<TenantProfileResponse>> getProfile() {
        return ResponseEntity.ok(tenantService.getProfile(null));
    }

    @PutMapping("/profile")
    @PreAuthorize("hasRole('TENANT')")
    public ResponseEntity<ApiResponse<TenantProfileResponse>> updateProfile(@RequestBody TenantProfileRequest request) {
        return ResponseEntity.ok(tenantService.updateProfile(null, request));
    }
}
