package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobSeekerService;
import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jobseekers")
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/jobseeker")
    public DataResult<JobSeeker> addJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) throws Exception {

        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobseekers")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }
}
