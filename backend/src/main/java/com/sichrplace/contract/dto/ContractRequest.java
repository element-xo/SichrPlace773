package com.sichrplace.contract.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContractRequest {
    private Long listingId;
    private Long tenantProfileId;
    private Long landlordProfileId;
    private String fullNameTenant;
    private String fullNameLandlord;
    private BigDecimal monthlyRent;
    private BigDecimal depositAmount;
}
