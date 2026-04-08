package com.sichrplace.support;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.support.dto.SupportTicketRequest;
import com.sichrplace.support.dto.SupportTicketResponse;
import java.util.List;

public interface SupportService {
    ApiResponse<SupportTicketResponse> createTicket(SupportTicketRequest request);
    ApiResponse<List<SupportTicketResponse>> listTickets();
}
