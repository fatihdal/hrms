package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "role_name")
    //@NonNull
    private String roleName;
}
