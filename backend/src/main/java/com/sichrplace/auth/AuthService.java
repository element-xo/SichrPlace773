package com.sichrplace.auth;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.auth.dto.LoginRequest;
import com.sichrplace.auth.dto.RegisterRequest;
import com.sichrplace.auth.dto.TokenRefreshRequest;
import com.sichrplace.auth.dto.AuthResponse;

public interface AuthService {
    ApiResponse<AuthResponse> register(RegisterRequest request);
    ApiResponse<AuthResponse> login(LoginRequest request);
    ApiResponse<AuthResponse> refreshToken(TokenRefreshRequest request);
    ApiResponse<Void> logout(Long userId);
}
