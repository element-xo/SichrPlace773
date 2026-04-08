package com.sichrplace.listing;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.listing.dto.ListingRequest;
import com.sichrplace.listing.dto.ListingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final ApartmentListingRepository apartmentListingRepository;

    @Override
    public ApiResponse<Page<ListingResponse>> listListings(Pageable pageable) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<ListingResponse> getListing(Long id) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<ListingResponse> createListing(ListingRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<ListingResponse> updateListing(Long id, ListingRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> deleteListing(Long id) {
        throw new UnsupportedOperationException("TODO");
    }
}
