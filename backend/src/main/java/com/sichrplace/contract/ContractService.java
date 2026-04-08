package com.sichrplace.contract;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.contract.dto.ContractRequest;
import com.sichrplace.contract.dto.ContractResponse;

public interface ContractService {
    ApiResponse<ContractResponse> createContract(ContractRequest request);
    ApiResponse<ContractResponse> getContract(Long id);
}
