package com.sichrplace.tenant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TenantProfileRequest {
    private String firstName;
    private String lastName;
    private String currentCity;
    private String bio;
}
