package com.sichrplace.landlord;

import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.common.entity.Hobby;
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
@Table(name = "landlord_hobbies", schema = "sichr", uniqueConstraints = {@UniqueConstraint(columnNames = {"landlord_profile_id","hobby_id"})})
public class LandlordHobby extends BaseEntity {

    // updated_at not present in schema — intentional

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_profile_id", nullable = false)
    private LandlordProfile landlordProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;
}
