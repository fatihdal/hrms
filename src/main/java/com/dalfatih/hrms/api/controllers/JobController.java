package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobService;
import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.core.utilities.results.SuccessDataResult;
import com.dalfatih.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobs")
    public DataResult<List<Job>> getAll() {
        return this.jobService.getAll();
    }
}
