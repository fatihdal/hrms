package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "job_seekers", uniqueConstraints =
        {@UniqueConstraint(columnNames = "national_id", name = "uk_national_id"),
                @UniqueConstraint(columnNames = "email", name = "uk_user_email")})
public class JobSeeker extends BaseEntity implements UserDetails {

    @Column(name = "first_name")
    /*@NotNull(message = "First name must not be empty")
    @Size(min = 3, max = 20, message = "First name length must be between 3 and 20")*/
    private String firstName;

    @Column(name = "last_name")
    /*@NotNull(message = "Last name must not be empty")
    @Size(min = 3, max = 25, message = "Last name length must be between 3 and 25")*/
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    //@NotNull(message = "Date of birth must not be empty")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;

    //private Long emailVerifyId;

    @NotNull(message = "National id must not be empty")
    @Size(min = 11, max = 11, message = "National id length must be 11 characters")
    @Column(name = "national_id")
    private String nationalId;

    /*@Embedded
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

    /*@Column(name = "email_verify_Id")
    private Long emailVerifyId;*/

    @Column(name = "locked")
    private Boolean locked = true;

    @Column(name = "enabled")
    private Boolean enabled = false;

    @Column(name = "phone")
    private String phone;

    public JobSeeker (String firstName,
                     String lastName,
                     LocalDate dateOfBirth,
                     String email,
                      String nationalId,
                     String password,
                     Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.nationalId = nationalId;
        this.password = password;
        this.role = role;
    }

    public JobSeeker(String firstName, String lastName, LocalDate dateOfBirth, String nationalId, String pass, String phone) {
        super();
    }

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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
