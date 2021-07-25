package com.dalfatih.hrms.dtos;

import com.dalfatih.hrms.entities.concretes.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class JobSeekerDto {

    private Long id;

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

    @NotNull(message = "National id must not be empty")
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = "lenght 11 digit")
    private String nationalId;

    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}$",
            message = "8 and 15 characters long, must contain at least one number," +
                    " at least one uppercase letter, at least one lowercase letter," +
                    " and at least one special character")
    private String password;

    @Pattern(regexp = "^(05)([0-9]{2})\\-?([0-9]{3})\\-?([0-9]{2})\\-?([0-9]{2})$",message = "05xx-xxx-xx-xx")
    private String phone;
}
