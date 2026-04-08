package com.sichrplace.payment;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.payment.dto.DepositResponse;
import com.sichrplace.payment.dto.RentScheduleResponse;
import java.util.List;

public interface PaymentService {
    ApiResponse<List<RentScheduleResponse>> listRentSchedules();
    ApiResponse<Void> payRentSchedules();
    ApiResponse<List<DepositResponse>> listDeposits();
    ApiResponse<Void> releaseDeposit();
}
