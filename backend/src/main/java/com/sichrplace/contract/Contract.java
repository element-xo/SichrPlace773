package com.sichrplace.contract;

import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.listing.ApartmentListing;
import com.sichrplace.landlord.LandlordProfile;
import com.sichrplace.tenant.TenantProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contracts", schema = "sichr")
public class Contract extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private ApartmentListing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_profile_id", nullable = false)
    private TenantProfile tenantProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_profile_id", nullable = false)
    private LandlordProfile landlordProfile;

    @Column(name = "full_name_tenant", nullable = false)
    private String fullNameTenant;

    @Column(name = "full_name_landlord", nullable = false)
    private String fullNameLandlord;

    @Column(name = "apartment_details")
    private String apartmentDetails;

    @Column(name = "move_in_date")
    private LocalDate moveInDate;

    @Column(name = "move_out_date")
    private LocalDate moveOutDate;

    @Column(name = "monthly_rent", nullable = false)
    private BigDecimal monthlyRent;

    @Column(name = "deposit_amount", nullable = false)
    private BigDecimal depositAmount;

    @Column(name = "next_due_date")
    private LocalDate nextDueDate;

    @Column(name = "contract_status", nullable = false)
    private String contractStatus;

    @Column(name = "contract_pdf_url")
    private String contractPdfUrl;

    @Column(name = "signed_at")
    private LocalDateTime signedAt;
}
