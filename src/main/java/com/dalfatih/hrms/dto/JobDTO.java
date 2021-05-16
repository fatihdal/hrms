package com.dalfatih.hrms.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class JobDTO {

    private Long id;

    private Long jobCategoryId;

    @NotNull(message = "Title must not be empty")
    @Size(min = 3, max = 60, message = "Title length must be between 3 and 60")
    private String jobTitle;

    @NotNull(message = "Description must not be empty")
    @Size(min = 5, max = 60, message = "Description length must be between 5 and 60")
    private String jobDescription;
}
