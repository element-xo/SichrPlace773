package com.sichrplace.listing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListingResponse {
    private Long id;
    private String title;
    private String city;
    private String country;
}
