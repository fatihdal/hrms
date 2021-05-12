package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobCategoryService;
import com.dalfatih.hrms.dto.JobCategoryDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobcategories")
@Data
public class JobCategoriesController {

    private JobCategoryService jobCategoryService;

    @Autowired
    public JobCategoriesController(JobCategoryService jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getall")
    public List<JobCategoryDTO> getAll() {
        return this.jobCategoryService.getAll();
    }
}
