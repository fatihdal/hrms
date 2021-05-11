package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.dto.JobCategoryDTO;

import java.util.List;

public interface JobCategoryService {

    List<JobCategoryDTO> getAll();
}
