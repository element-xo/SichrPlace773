package com.sichrplace.contract;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.contract.dto.ContractRequest;
import com.sichrplace.contract.dto.ContractResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Override
    public ApiResponse<ContractResponse> createContract(ContractRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<ContractResponse> getContract(Long id) {
        throw new UnsupportedOperationException("TODO");
    }
}
