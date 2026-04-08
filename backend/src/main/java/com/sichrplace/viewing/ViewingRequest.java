package com.sichrplace.viewing;

import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.common.enums.ViewingStatus;
import com.sichrplace.landlord.LandlordProfile;
import com.sichrplace.listing.ApartmentListing;
import com.sichrplace.tenant.TenantProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "viewing_requests", schema = "sichr")
public class ViewingRequest extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private ApartmentListing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_profile_id", nullable = false)
    private TenantProfile tenantProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_profile_id", nullable = false)
    private LandlordProfile landlordProfile;

    @Column(name = "proposed_datetime", nullable = false)
    private LocalDateTime proposedDatetime;

    @Column(name = "confirmed_datetime")
    private LocalDateTime confirmedDatetime;

    @Enumerated(EnumType.STRING)
    @Column(name = "viewing_status", nullable = false)
    private ViewingStatus viewingStatus;

    @Column(name = "rejection_reason")
    private String rejectionReason;
}
