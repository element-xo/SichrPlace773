package com.sichrplace.landlord;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.landlord.dto.LandlordProfileRequest;
import com.sichrplace.landlord.dto.LandlordProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/landlord")
@RequiredArgsConstructor
public class LandlordController {

    private final LandlordService landlordService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<String>> getDashboard() {
        return ResponseEntity.ok(landlordService.getDashboard(null));
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<LandlordProfileResponse>> getProfile() {
        return ResponseEntity.ok(landlordService.getProfile(null));
    }

    @PutMapping("/profile")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<LandlordProfileResponse>> updateProfile(@RequestBody LandlordProfileRequest request) {
        return ResponseEntity.ok(landlordService.updateProfile(null, request));
    }
}
