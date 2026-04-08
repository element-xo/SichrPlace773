package com.sichrplace.tenant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TenantProfileResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String currentCity;
    private String bio;
}
