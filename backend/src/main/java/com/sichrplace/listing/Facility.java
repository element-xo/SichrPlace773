package com.sichrplace.listing;

import com.sichrplace.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "facilities", schema = "sichr")
public class Facility extends BaseEntity {

    // updated_at not present in schema — intentional

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "icon_key")
    private String iconKey;
}
