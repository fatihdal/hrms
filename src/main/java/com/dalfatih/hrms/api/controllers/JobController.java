package com.dalfatih.hrms.api.controllers;

import com.dalfatih.hrms.business.abstracts.JobService;
import com.dalfatih.hrms.dto.CreateObjectResponse;
import com.dalfatih.hrms.dto.JobDTO;
import com.dalfatih.hrms.exception.RecordNotFoundException;
import lombok.Data;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hrms/jobs")
@Data
public class JobController {

    private final JobService jobService;
    private final CreateObjectResponse createObjectResponse;


    @RequestMapping(method = RequestMethod.POST, value = "/job")
    public ResponseEntity<CreateObjectResponse> addJob(@Valid @RequestBody JobDTO jobDTO) {

        createObjectResponse.setId(jobService.addJob(jobDTO).getId());

        return new ResponseEntity<CreateObjectResponse>(createObjectResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jobs")
    public List<JobDTO> getAll() {
        return this.jobService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/job/{id}")
    public ResponseEntity<JobDTO> getTask(@PathVariable("id") Long id) throws RecordNotFoundException {
        try {
            return ResponseEntity.ok().body(jobService.getById(id));
        } catch (EntityNotFoundException ex) {
            throw new RecordNotFoundException("id = " + id);
        }
    }
}
