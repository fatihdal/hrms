package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobService;
import com.dalfatih.hrms.dto.CreateObjectResponse;
import com.dalfatih.hrms.dto.JobDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService jobService;
    private final CreateObjectResponse createObjectResponse;

    @Autowired
    public JobController(JobService jobService, CreateObjectResponse createObjectResponse) {
        this.jobService = jobService;
        this.createObjectResponse = createObjectResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobs")
    public List<JobDTO> getAll() {
        return this.jobService.getAll();
    }
}
