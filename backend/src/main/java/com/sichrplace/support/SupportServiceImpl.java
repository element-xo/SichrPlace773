package com.sichrplace.support;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.support.dto.SupportTicketRequest;
import com.sichrplace.support.dto.SupportTicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SupportServiceImpl implements SupportService {

    private final com.sichrplace.admin.SupportTicketRepository supportTicketRepository;

    @Override
    public ApiResponse<SupportTicketResponse> createTicket(SupportTicketRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<java.util.List<SupportTicketResponse>> listTickets() {
        throw new UnsupportedOperationException("TODO");
    }
}
