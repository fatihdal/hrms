package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity implements UserDetails {

    @Column(name = "company_name")
    @NotNull(message = "Company name must not be empty")
    @Size(min = 3, max = 20, message = "Company name length must be between 3 and 30")
    private String companyName;

    private String website;
/*
    @Embedded
    private User user;*/

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Email
    @NotEmpty(message = "Email must not be empty")
    @Column(name = "email", length = 45)
    private String email;

    @NotNull(message = "Password must not be empty")
    @Size(min = 8, max = 64, message = "Password length must be between 8 and 64")
    @Column(name = "password")
    private String password;

    @Column(name = "email_verify_Id")
    private Long emailVerifyId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "phone")
    private String phone;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
