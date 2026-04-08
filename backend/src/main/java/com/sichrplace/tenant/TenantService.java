package com.sichrplace.tenant;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.tenant.dto.TenantProfileRequest;
import com.sichrplace.tenant.dto.TenantProfileResponse;

public interface TenantService {
    ApiResponse<String> getDashboard(Long userId);
    ApiResponse<TenantProfileResponse> getProfile(Long userId);
    ApiResponse<TenantProfileResponse> updateProfile(Long userId, TenantProfileRequest request);
}
