package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {

    @Column(name = "company_name")
    @NotNull(message = "Company name must not be empty")
    @Size(min = 3, max = 20, message = "Company name length must be between 3 and 30")
    private String companyName;

    private String website;

    @Embedded
    private User user;
}
