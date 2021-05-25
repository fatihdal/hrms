package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.entities.concretes.JobCategory;

import java.util.List;

public interface JobCategoryService {

    List<JobCategory> getAll();
}
