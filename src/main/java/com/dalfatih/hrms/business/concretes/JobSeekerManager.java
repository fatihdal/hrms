package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.JobSeekerService;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobRepository;
import com.dalfatih.hrms.dto.JobSeekerDTO;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobSeekerManager implements JobSeekerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ModelMapper modelMapper = new ModelMapper();
    private final JobRepository jobRepository;
    private final JobCategoryRepository jobCategoryRepository;

    @Override
    public JobSeeker addJobSeeker(JobSeekerDTO jobSeekerDTO) {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setFirstName(jobSeekerDTO.getFirstName());
        jobSeeker.setLastName(jobSeekerDTO.getLastName());
        jobSeeker.setNationalId(jobSeekerDTO.getNationalId());
        jobSeeker.setDateOfBirth(jobSeekerDTO.getDateOfBirth());
       /*if(jobSeekerCheckService.(jobSeeker)) {
           logger.warn("yes");
       }*/



/*
        final Job jobDb = jobRepository.save(job);
        jobDTO.setId(jobDb.getId());

        logger.info("'" + jobDTO + "' is created");*/

        return null;

    }
}
