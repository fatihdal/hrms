package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.JobService;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobRepository;
import com.dalfatih.hrms.dto.JobDTO;
import com.dalfatih.hrms.entities.concretes.Job;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobManager implements JobService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ModelMapper modelMapper = new ModelMapper();
    private final JobRepository jobRepository;
    private final JobCategoryRepository jobCategoryRepository;

    @Override
    public Job addJob(JobDTO jobDTO) {
        JobCategory jobCategory = jobCategoryRepository.getOne(jobDTO.getJobCategoryId());
        Job job = new Job();
        job.setJobCategory(jobCategory);
        job.setId(jobDTO.getId());
        job.setJobTitle(jobDTO.getJobTitle());
        job.setJobDescription(jobDTO.getJobDescription());

        final Job jobDb = jobRepository.save(job);
        jobDTO.setId(jobDb.getId());

        logger.info("'" + jobDTO + "' is created");

        return job;
    }

    @Override
    public List<JobDTO> getAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOs = new ArrayList<>();
        jobs.forEach(job -> jobDTOs.add(modelMapper.map(job, JobDTO.class)));

        logger.info("All jobs are listed");

        return jobDTOs;
    }

    @Override
    public Job getById(Long jobId) {
        //TODO
        return null;
    }

    @Override
    public Job delete(Long jobId) {
        //TODO
        return null;
    }

    @Override
    public List<JobDTO> filterByTitleOrDescription(String keyword) {
        //TODO
        return null;
    }
}
