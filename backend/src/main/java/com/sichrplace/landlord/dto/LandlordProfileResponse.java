package com.sichrplace.landlord.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LandlordProfileResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String currentCity;
    private String bio;
}
