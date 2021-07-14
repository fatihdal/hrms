package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import com.dalfatih.hrms.entities.concretes.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
/*@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "users", uniqueConstraints =
        {@UniqueConstraint(columnNames = "email", name = "uk_user_email")})*/
public class User {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Email
    @NotEmpty(message = "Email must not be empty")
    @Column(name = "email", length = 45)
    private String email;

    @NotNull(message = "Password must not be empty")
    @Size(min = 8, max = 64, message = "Password length must be between 8 and 64")
    @Column(name = "pass")
    private String pass;

    @Column(name = "email_verify_Id")
    private Long emailVerifyId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "phone")
    private String phone;

  /*  @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;*/
}