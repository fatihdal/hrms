package com.dalfatih.hrms.dataAccess.abstracts;

import com.dalfatih.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
