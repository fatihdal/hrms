package com.dalfatih.hrms.entities.abstracts;

import com.dalfatih.hrms.entities.concretes.Role;
import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class User extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role_id"))
    @NonNull
    private Role roleId;

    @Column(name = "user_email", unique = true)
    @NonNull
    private String email;

    @Column(name = "pass", nullable = false)
    @NonNull
    private String pass;

    @Column(name = "is_active")
    private boolean isActive;
}