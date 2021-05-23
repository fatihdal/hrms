package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobSeekerService;
import com.dalfatih.hrms.dto.CreateObjectResponse;
import com.dalfatih.hrms.dto.JobSeekerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final CreateObjectResponse createObjectResponse;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService, CreateObjectResponse createObjectResponse) {
        this.jobSeekerService = jobSeekerService;
        this.createObjectResponse = createObjectResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/jobseeker")
    public ResponseEntity<CreateObjectResponse> addJobSeeker(@Valid @RequestBody JobSeekerDTO jobSeekerDTO) throws Exception {

        createObjectResponse.setId(jobSeekerService.addJobSeeker(jobSeekerDTO).getId());
        return new ResponseEntity<CreateObjectResponse>(createObjectResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobseekers")
    public List<JobSeekerDTO> getAll() {
        return this.jobSeekerService.getAll();
    }
}
