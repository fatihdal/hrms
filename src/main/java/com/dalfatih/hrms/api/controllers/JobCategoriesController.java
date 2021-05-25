package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobCategoryService;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobcategories")
public class JobCategoriesController {

    private final JobCategoryService jobCategoryService;

    @Autowired
    public JobCategoriesController(JobCategoryService jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    public List<JobCategory> getAll() {
        return this.jobCategoryService.getAll();
    }
}
