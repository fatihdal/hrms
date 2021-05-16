package com.dalfatih.hrms.dto;

import com.dalfatih.hrms.entities.concretes.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JobSeekerDTO {

    private Long id;

    @NotNull(message = "First name must not be empty")
    @Size(min = 3, max = 20, message = "First name length must be between 3 and 20")
    private String firstName;

    @NotNull(message = "Last name must not be empty")
    @Size(min = 3, max = 25, message = "Last name length must be between 3 and 25")
    private String lastName;

    //@NotEmpty(message = "Email must not be empty")
    @Email
    private String email;

    @NotNull(message = "Password must not be empty")
    @Size(min = 8, max = 64, message = "Password length must be between 8 and 64")
    private String pass;

    @NotNull(message = "National id must not be empty")
    @Size(min = 11, max = 11, message = "National id length must be 11 characters")
    private String nationalId;

    private Gender gender;

    @NotNull(message = "Date of birth must not be empty")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;
}
