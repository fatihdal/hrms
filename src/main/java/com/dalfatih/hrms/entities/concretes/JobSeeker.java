package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.Person;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "job_seekers", uniqueConstraints =
        {@UniqueConstraint(columnNames = "user_email", name = "uk_user_email"),
                @UniqueConstraint(columnNames = "national_id", name = "uk_national_id")})
public class JobSeeker extends Person {

    @NonNull
    private Long emailVerifyId;

    @NonNull
    @Column(name = "national_id")
    private String nationalId;
}
