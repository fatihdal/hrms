package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.Person;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
@Table(name = "job_seekers")
public class JobSeeker extends Person {

    private Long emailVerifyId;

    @Column(name = "national_id", unique = true)
    private String nationalId;
}
