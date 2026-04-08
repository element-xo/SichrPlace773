package com.sichrplace.common.entity;

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
@Table(name = "hobbies", schema = "sichr")
public class Hobby extends BaseEntity {

    // updated_at not present in schema — intentional

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
