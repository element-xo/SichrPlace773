package com.sichrplace.payment;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.payment.dto.DepositResponse;
import com.sichrplace.payment.dto.RentScheduleResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final RentScheduleRepository rentScheduleRepository;
    private final DepositRepository depositRepository;

    @Override
    public ApiResponse<List<RentScheduleResponse>> listRentSchedules() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> payRentSchedules() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<List<DepositResponse>> listDeposits() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> releaseDeposit() {
        throw new UnsupportedOperationException("TODO");
    }
}
