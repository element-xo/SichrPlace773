package com.sichrplace.contract;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.contract.dto.ContractRequest;
import com.sichrplace.contract.dto.ContractResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<ContractResponse>> createContract(@RequestBody ContractRequest request) {
        return ResponseEntity.ok(contractService.createContract(request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<ContractResponse>> getContract(@PathVariable Long id) {
        return ResponseEntity.ok(contractService.getContract(id));
    }
}
