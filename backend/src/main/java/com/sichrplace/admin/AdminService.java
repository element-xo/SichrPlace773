package com.sichrplace.admin;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.admin.dto.SupportTicketStatusRequest;
import java.util.List;

public interface AdminService {
    ApiResponse<List<String>> listUsers();
    ApiResponse<Void> updateUserStatus(Long id, SupportTicketStatusRequest request);
    ApiResponse<List<String>> listTickets();
    ApiResponse<Void> updateTicketStatus(Long id, SupportTicketStatusRequest request);
}
