package com.sichrplace.auth;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.auth.dto.AuthResponse;
import com.sichrplace.auth.dto.LoginRequest;
import com.sichrplace.auth.dto.RegisterRequest;
import com.sichrplace.auth.dto.TokenRefreshRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public ApiResponse<AuthResponse> register(RegisterRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<AuthResponse> login(LoginRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<AuthResponse> refreshToken(TokenRefreshRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> logout(Long userId) {
        throw new UnsupportedOperationException("TODO");
    }
}
