package com.dalfatih.hrms.dataAccess.abstracts;

import com.dalfatih.hrms.entities.concretes.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {
}
