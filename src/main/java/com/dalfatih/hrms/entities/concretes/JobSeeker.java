package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
@Table(name = "job_seekers")
public class JobSeeker extends Person {

    private Long emailVerifyId;

    @Column(name = "national_id")
    private String nationalId;
}
