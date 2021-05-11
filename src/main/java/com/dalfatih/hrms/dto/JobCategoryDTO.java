package com.dalfatih.hrms.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JobCategoryDTO {

    int id;
    String title;
    String description;
}
