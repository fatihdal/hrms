package com.dalfatih.hrms.entities.abstracts;

import com.dalfatih.hrms.entities.concretes.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class User extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "role_id")
    private Role role;

    @Email
    @Column(name = "user_email", length = 45)
    private String email;

    @Column(name = "pass")
    private String pass;

    @Column(name = "is_active")
    private boolean isActive;
}