package com.sichrplace.landlord;

import com.sichrplace.auth.User;
import com.sichrplace.common.entity.BaseEntity;
import com.sichrplace.common.enums.Gender;
import com.sichrplace.common.enums.PersonalityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "landlord_profiles", schema = "sichr", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})})
public class LandlordProfile extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "profile_photo_url")
    private String profilePhotoUrl;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "current_city")
    private String currentCity;

    @Column(name = "bio")
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(name = "personality_type")
    private PersonalityType personalityType;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "contact_link")
    private String contactLink;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "landlordProfile", fetch = FetchType.LAZY)
    private List<LandlordHobby> landlordHobbies;
}
