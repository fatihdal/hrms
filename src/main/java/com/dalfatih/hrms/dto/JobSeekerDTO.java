package com.dalfatih.hrms.dto;

import com.dalfatih.hrms.entities.concretes.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JobSeekerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String pass;
    private String nationalId;
    private Gender gender;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateOfBirth;
}
