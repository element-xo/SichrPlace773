package com.sichrplace.support;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.support.dto.SupportTicketRequest;
import com.sichrplace.support.dto.SupportTicketResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/support")
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;

    @PostMapping("/tickets")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<SupportTicketResponse>> createTicket(@RequestBody SupportTicketRequest request) {
        return ResponseEntity.ok(supportService.createTicket(request));
    }

    @GetMapping("/tickets")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<List<SupportTicketResponse>>> listTickets() {
        return ResponseEntity.ok(supportService.listTickets());
    }
}
