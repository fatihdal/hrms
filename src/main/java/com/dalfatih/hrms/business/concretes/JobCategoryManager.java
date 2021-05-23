package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.JobCategoryService;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dto.JobCategoryDTO;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobCategoryManager implements JobCategoryService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ModelMapper modelMapper = new ModelMapper();
    private final JobCategoryRepository jobCategoryRepository;

    @Autowired
    public JobCategoryManager(JobCategoryRepository jobCategoryRepository) {
        this.jobCategoryRepository = jobCategoryRepository;
    }

    @Override
    public List<JobCategoryDTO> getAll() {
        List<JobCategory> jobCategories = jobCategoryRepository.findAll();
        List<JobCategoryDTO> jobCategoryDTOs = new ArrayList<>();
        jobCategories.forEach(jobCategory -> jobCategoryDTOs.add(modelMapper.map(jobCategory, JobCategoryDTO.class)));

        logger.info("All job categories are listed");

        return jobCategoryDTOs;
    }

}