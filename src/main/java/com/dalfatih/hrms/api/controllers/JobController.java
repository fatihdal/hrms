package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobService;
import com.dalfatih.hrms.dto.JobDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@Data
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getall")
    public List<JobDTO> getAll() {
        return this.jobService.getAll();
    }
}
