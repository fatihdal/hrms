package com.dalfatih.hrms.mem;

import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobSeekerRepository;
import com.dalfatih.hrms.dataAccess.abstracts.RoleRepository;
import com.dalfatih.hrms.entities.concretes.Job;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import com.dalfatih.hrms.entities.concretes.Role;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppStart implements CommandLineRunner {

    private JobRepository jobRepository;
    private JobCategoryRepository jobCategoryRepository;
    private JobSeekerRepository jobSeekerRepository;
    private RoleRepository roleRepository;

    public AppStart(JobRepository jobRepository, JobCategoryRepository jobCategoryRepository
            , JobSeekerRepository jobSeekerRepository, RoleRepository roleRepository) {
        this.jobRepository = jobRepository;
        this.jobCategoryRepository = jobCategoryRepository;
        this.jobSeekerRepository = jobSeekerRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        //Add job categories
        for (int a = 1; a < 5; a++) {
            JobCategory jobCategory = new JobCategory("Category" + a, "description of " + "category" + a);
            JobCategory category = jobCategoryRepository.save(jobCategory);
            //Add jobs
            for (int i = 1; i < 5; i++) {
                Job job = new Job();
                job.setJobCategory(category);
                job.setJobDescription("Description of job " + i);
                job.setJobTitle(i + ". job," + " of the category" + a);
                jobRepository.save(job);
            }
        }
        for (int a = 1; a < 3; a++) {
            Role role = new Role();
            role.setRoleName("Admin");
            roleRepository.save(role);
            Role role1 = new Role();
            role.setRoleName("User");
            roleRepository.save(role1);
            for (int i = 1; i < 10; i++) {
                JobSeeker jobSeeker = new JobSeeker();
                jobSeeker.setFirstName("First name" + i);
                jobSeeker.setLastName("LASTNAME" + i);
                jobSeeker.setEmail(i + "Email" + a + "@example.com");
                jobSeeker.setNationalId("1234567890" + i);
                jobSeeker.setPass("1234567891022" + i);
                if (i >= 5) {
                    jobSeeker.setRoleId(role1);
                } else {
                    jobSeeker.setRoleId(role);
                }
                jobSeekerRepository.save(jobSeeker);
            }
        }
    }

}