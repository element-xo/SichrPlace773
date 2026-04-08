package com.sichrplace.tenant;

import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.common.entity.Hobby;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tenant_hobbies", schema = "sichr", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_profile_id","hobby_id"})})
public class TenantHobby extends BaseEntity {

    // updated_at not present in schema — intentional

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_profile_id", nullable = false)
    private TenantProfile tenantProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;
}
