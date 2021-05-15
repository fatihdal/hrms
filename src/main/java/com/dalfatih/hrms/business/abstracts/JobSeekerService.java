package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.dto.JobSeekerDTO;
import com.dalfatih.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

    JobSeeker addJobSeeker(JobSeekerDTO jobSeekerDTO);
}
