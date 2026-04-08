package com.sichrplace.contract.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContractResponse {
    private Long id;
    private String fullNameTenant;
    private String fullNameLandlord;
    private BigDecimal monthlyRent;
}
