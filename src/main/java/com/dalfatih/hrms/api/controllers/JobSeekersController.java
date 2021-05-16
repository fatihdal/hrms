package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobSeekerService;
import com.dalfatih.hrms.dto.CreateObjectResponse;
import com.dalfatih.hrms.dto.JobSeekerDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Data
@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;
    private final CreateObjectResponse createObjectResponse;

    @RequestMapping(method = RequestMethod.POST, value = "/jobseeker")
    public ResponseEntity<CreateObjectResponse> addJobSeeker(@Valid @RequestBody JobSeekerDTO jobSeekerDTO) throws Exception {
        try {
            createObjectResponse.setId(jobSeekerService.addJobSeeker(jobSeekerDTO).getId());
            return new ResponseEntity<CreateObjectResponse>(createObjectResponse, HttpStatus.CREATED);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobseekers")
    public List<JobSeekerDTO> getAll() {
        return this.jobSeekerService.getAll();
    }
}
