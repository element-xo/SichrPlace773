package com.sichrplace.listing;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.listing.dto.ListingRequest;
import com.sichrplace.listing.dto.ListingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListingService {
    ApiResponse<Page<ListingResponse>> listListings(Pageable pageable);
    ApiResponse<ListingResponse> getListing(Long id);
    ApiResponse<ListingResponse> createListing(ListingRequest request);
    ApiResponse<ListingResponse> updateListing(Long id, ListingRequest request);
    ApiResponse<Void> deleteListing(Long id);
}
