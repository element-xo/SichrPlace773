package com.sichrplace.payment;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.payment.dto.DepositResponse;
import com.sichrplace.payment.dto.RentScheduleResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/rent-schedules")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<List<RentScheduleResponse>>> listRentSchedules() {
        return ResponseEntity.ok(paymentService.listRentSchedules());
    }

    @PostMapping("/rent-schedules")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<Void>> payRentSchedules() {
        return ResponseEntity.ok(paymentService.payRentSchedules());
    }

    @GetMapping("/deposits")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<List<DepositResponse>>> listDeposits() {
        return ResponseEntity.ok(paymentService.listDeposits());
    }

    @PostMapping("/deposits")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<Void>> releaseDeposit() {
        return ResponseEntity.ok(paymentService.releaseDeposit());
    }
}
