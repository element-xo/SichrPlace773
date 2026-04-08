package com.sichrplace.auth;

import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.common.enums.Role;
import com.sichrplace.common.enums.UserStatus;
import com.sichrplace.landlord.LandlordProfile;
import com.sichrplace.tenant.TenantProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "sichr")
public class User extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Column(name = "email_verified", nullable = false)
    private Boolean emailVerified;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "user", fetch = jakarta.persistence.FetchType.LAZY)
    private List<RefreshToken> refreshTokens;

    @OneToOne(mappedBy = "user", fetch = jakarta.persistence.FetchType.LAZY)
    private TenantProfile tenantProfile;

    @OneToOne(mappedBy = "user", fetch = jakarta.persistence.FetchType.LAZY)
    private LandlordProfile landlordProfile;
}
