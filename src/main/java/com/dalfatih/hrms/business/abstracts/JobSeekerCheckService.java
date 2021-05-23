package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Component;

@Component
public interface JobSeekerCheckService {

    boolean checkIfRealPerson(JobSeeker jobSeeker);
}