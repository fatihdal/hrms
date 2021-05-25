package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.JobService;
import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.core.utilities.results.SuccessDataResult;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobRepository;
import com.dalfatih.hrms.entities.concretes.Job;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobManager implements JobService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JobRepository jobRepository;
    private final JobCategoryRepository jobCategoryRepository;

    @Override
    public DataResult<Job> addJob(Job job) {
        JobCategory jobCategory = jobCategoryRepository.getOne(job.getJobCategory().getId());
        job.setJobCategory(jobCategory);
        final Job jobDb = jobRepository.save(job);
        job.setId(jobDb.getId());

        logger.info(job + "' is created");

        return new SuccessDataResult<>(jobDb, "Job is created");
    }

    @Override
    public DataResult<List<Job>> getAll() {
        List<Job> jobs = jobRepository.findAll();

        logger.info("All jobs are listed");

        return new SuccessDataResult<>(jobs, "All jobs are listed");
    }

    @Override
    public DataResult<Job> getById(Long jobId) {
        //TODO
        return null;
    }

    @Override
    public DataResult<Job> delete(Long jobId) {
        //TODO
        return null;
    }

    @Override
    public DataResult<List<Job>> filterByTitleOrDescription(String keyword) {
        //TODO
        return null;
    }
}
