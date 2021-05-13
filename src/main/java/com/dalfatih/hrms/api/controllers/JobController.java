package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobService;
import com.dalfatih.hrms.dto.CreateObjectResponse;
import com.dalfatih.hrms.dto.JobDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@Data
public class JobController {

    private final JobService jobService;
    private final CreateObjectResponse createObjectResponse;


    @RequestMapping(method = RequestMethod.POST, value = "/job")
    public ResponseEntity<CreateObjectResponse> addJob(@Valid @RequestBody JobDTO jobDTO) {

        createObjectResponse.setId(jobService.addJob(jobDTO).getId());

        return new ResponseEntity<CreateObjectResponse>(createObjectResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getall")
    public List<JobDTO> getAll() {
        return this.jobService.getAll();
    }
}
