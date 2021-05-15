package com.dalfatih.hrms.dataAccess.abstracts;

import com.dalfatih.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
}