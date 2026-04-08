package com.sichrplace.messaging;

import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.landlord.LandlordProfile;
import com.sichrplace.listing.ApartmentListing;
import com.sichrplace.tenant.TenantProfile;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "message_threads", schema = "sichr")
public class MessageThread extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private ApartmentListing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_profile_id", nullable = false)
    private TenantProfile tenantProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_profile_id", nullable = false)
    private LandlordProfile landlordProfile;

    @OneToMany(mappedBy = "thread", fetch = FetchType.LAZY)
    private List<Message> messages;
}
