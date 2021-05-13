package com.dalfatih.hrms.mem;

import com.dalfatih.hrms.business.concretes.JobManager;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobRepository;
import com.dalfatih.hrms.entities.concretes.Job;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppStart implements CommandLineRunner {

    private JobRepository jobRepository;
    private JobCategoryRepository jobCategoryRepository;
    private JobManager jobManager;

    public AppStart(JobRepository jobRepository, JobCategoryRepository jobCategoryRepository) {
        this.jobRepository = jobRepository;
        this.jobCategoryRepository = jobCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for (int a = 1; a < 5; a++) {
            JobCategory jobCategory = new JobCategory("Category" + a, "description of " + "category" + a);
            JobCategory category = jobCategoryRepository.save(jobCategory);
            for (int i = 1; i < 5; i++) {
                Job job = new Job();
                job.setJobCategory(category);
                job.setJobDescription("Description of job " + i);
                job.setJobTitle(i + ". job," + " of the category" + a);
                jobRepository.save(job);
            }
        }
    }
}