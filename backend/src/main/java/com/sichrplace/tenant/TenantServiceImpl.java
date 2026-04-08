package com.sichrplace.tenant;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.tenant.dto.TenantProfileRequest;
import com.sichrplace.tenant.dto.TenantProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantProfileRepository tenantProfileRepository;

    @Override
    public ApiResponse<String> getDashboard(Long userId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<TenantProfileResponse> getProfile(Long userId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<TenantProfileResponse> updateProfile(Long userId, TenantProfileRequest request) {
        throw new UnsupportedOperationException("TODO");
    }
}
