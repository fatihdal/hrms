package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.Person;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "job_seekers", uniqueConstraints =
        {@UniqueConstraint(columnNames = "user_email", name = "uk_user_email"),
                @UniqueConstraint(columnNames = "national_id", name = "uk_national_id")})
public class JobSeeker extends Person {

    private Long emailVerifyId;

    @NotNull(message = "National id must not be empty")
    @Size(min = 11, max = 11, message = "National id length must be 11 characters")
    @Column(name = "national_id")
    private String nationalId;
}
