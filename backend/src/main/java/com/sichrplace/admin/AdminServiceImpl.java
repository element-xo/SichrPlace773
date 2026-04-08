package com.sichrplace.admin;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.admin.dto.SupportTicketStatusRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final SupportTicketRepository supportTicketRepository;

    @Override
    public ApiResponse<List<String>> listUsers() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> updateUserStatus(Long id, SupportTicketStatusRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<List<String>> listTickets() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> updateTicketStatus(Long id, SupportTicketStatusRequest request) {
        throw new UnsupportedOperationException("TODO");
    }
}
