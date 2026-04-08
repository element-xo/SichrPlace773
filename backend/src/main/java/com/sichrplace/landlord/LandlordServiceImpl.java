package com.sichrplace.landlord;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.landlord.dto.LandlordProfileRequest;
import com.sichrplace.landlord.dto.LandlordProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LandlordServiceImpl implements LandlordService {

    private final LandlordProfileRepository landlordProfileRepository;

    @Override
    public ApiResponse<String> getDashboard(Long userId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<LandlordProfileResponse> getProfile(Long userId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<LandlordProfileResponse> updateProfile(Long userId, LandlordProfileRequest request) {
        throw new UnsupportedOperationException("TODO");
    }
}
