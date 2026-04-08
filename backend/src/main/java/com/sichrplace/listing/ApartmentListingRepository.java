package com.sichrplace.listing;

import com.sichrplace.common.enums.ListingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentListingRepository extends JpaRepository<ApartmentListing, Long> {
    Page<ApartmentListing> findAllByListingStatusAndIsDeletedFalse(ListingStatus status, Pageable pageable);
}
