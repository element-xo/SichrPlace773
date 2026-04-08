package com.sichrplace.landlord;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.landlord.dto.LandlordProfileRequest;
import com.sichrplace.landlord.dto.LandlordProfileResponse;

public interface LandlordService {
    ApiResponse<String> getDashboard(Long userId);
    ApiResponse<LandlordProfileResponse> getProfile(Long userId);
    ApiResponse<LandlordProfileResponse> updateProfile(Long userId, LandlordProfileRequest request);
}
