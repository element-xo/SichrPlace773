package com.sichrplace.listing;

import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.common.enums.FurnishedStatus;
import com.sichrplace.common.enums.ListingStatus;
import com.sichrplace.landlord.LandlordProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "apartment_listings", schema = "sichr")
public class ApartmentListing extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_profile_id", nullable = false)
    private LandlordProfile landlordProfile;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "street_address", nullable = false)
    private String streetAddress;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "monthly_rent", nullable = false)
    private BigDecimal monthlyRent;

    @Column(name = "deposit_amount")
    private BigDecimal depositAmount;

    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;

    @Column(name = "floor_number")
    private Integer floorNumber;

    @Column(name = "size_sqm")
    private BigDecimal sizeSqm;

    @Enumerated(EnumType.STRING)
    @Column(name = "furnished_status")
    private FurnishedStatus furnishedStatus;

    @Column(name = "available_from")
    private LocalDate availableFrom;

    @Column(name = "available_to")
    private LocalDate availableTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_status", nullable = false)
    private ListingStatus listingStatus;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "listing", fetch = FetchType.LAZY)
    private List<ListingFacility> listingFacilities;

    @OneToMany(mappedBy = "listing", fetch = FetchType.LAZY)
    private List<ListingMedia> listingMedia;
}
