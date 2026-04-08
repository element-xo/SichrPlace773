package com.sichrplace.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TenantProfileRepository extends JpaRepository<TenantProfile, Long> {
    Optional<TenantProfile> findByUserId(Long userId);
}
