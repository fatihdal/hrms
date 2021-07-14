package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "job_seekers", uniqueConstraints =
        {@UniqueConstraint(columnNames = "national_id", name = "uk_national_id")})
public class JobSeeker extends BaseEntity {

    @Column(name = "first_name")
    /*@NotNull(message = "First name must not be empty")
    @Size(min = 3, max = 20, message = "First name length must be between 3 and 20")*/
    private String firstName;

    @Column(name = "last_name")
    /*@NotNull(message = "Last name must not be empty")
    @Size(min = 3, max = 25, message = "Last name length must be between 3 and 25")*/
    private String lastName;

    @Column(name = "gender")
    //@Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    //@NotNull(message = "Date of birth must not be empty")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;

    //private Long emailVerifyId;

    @NotNull(message = "National id must not be empty")
    @Size(min = 11, max = 11, message = "National id length must be 11 characters")
    @Column(name = "national_id")
    private String nationalId;

    @Embedded
    private User user;
}
