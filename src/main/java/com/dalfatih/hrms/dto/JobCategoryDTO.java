package com.dalfatih.hrms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class JobCategoryDTO {

   private int id;

    @NotNull(message = "Title must not be empty")
    @Length(min = 3, max = 60, message = "Title length must be between 3 and 60")
    private String jobCategoryTitle;



    @NotNull(message = "Description must not be empty")
    @Length(min = 5, max = 60, message = "Description length must be between 5 and 60")
   private String jobCategoryDescription;
}
