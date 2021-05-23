package com.dalfatih.hrms.entities.abstracts;

import com.dalfatih.hrms.entities.concretes.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class Person extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;
}
