package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.JobCategoryService;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobCategoryManager implements JobCategoryService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JobCategoryRepository jobCategoryRepository;

    @Override
    public List<JobCategory> getAll() {
        List<JobCategory> jobCategories = jobCategoryRepository.findAll();

        logger.info("All job categories are listed");

        return jobCategories;
    }
}