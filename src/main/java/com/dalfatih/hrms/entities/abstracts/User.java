package com.dalfatih.hrms.entities.abstracts;

import com.dalfatih.hrms.entities.concretes.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Email
    @NotEmpty(message = "Email must not be empty")
    @Column(name = "user_email", length = 45)
    private String email;

    @NotNull(message = "Password must not be empty")
    @Size(min = 8, max = 64, message = "Password length must be between 8 and 64")
    @Column(name = "pass")
    private String pass;

    @Column(name = "is_active")
    private boolean isActive;
}