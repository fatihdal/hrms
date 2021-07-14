package com.dalfatih.hrms.dtos;

import com.dalfatih.hrms.entities.concretes.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class JobSeekerDto {

    @NotNull(message = "First name must not be empty")
    @Size(min = 3, max = 20, message = "First name length must be between 3 and 20")
    private String firstName;

    @NotNull(message = "Last name must not be empty")
    @Size(min = 3, max = 25, message = "Last name length must be between 3 and 25")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Date of birth must not be empty")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;
    private String nationalId;
    private String email;
    private String pass;
    private String phone;
}
