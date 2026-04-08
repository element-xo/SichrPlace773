package com.sichrplace.listing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListingRequest {
    private String title;
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;
}
