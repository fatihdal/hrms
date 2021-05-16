package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.adapters.MernisServiceAdapter;
import com.dalfatih.hrms.business.abstracts.JobSeekerService;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobRepository;
import com.dalfatih.hrms.dataAccess.abstracts.JobSeekerRepository;
import com.dalfatih.hrms.dto.JobDTO;
import com.dalfatih.hrms.dto.JobSeekerDTO;
import com.dalfatih.hrms.entities.concretes.Gender;
import com.dalfatih.hrms.entities.concretes.Job;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSeekerManager implements JobSeekerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ModelMapper modelMapper = new ModelMapper();
    private final JobRepository jobRepository;
    private final JobCategoryRepository jobCategoryRepository;
    private final MernisServiceAdapter mernisServiceAdapter;
    private final JobSeekerRepository jobSeekerRepository;

    @Override
    public JobSeeker addJobSeeker(JobSeekerDTO jobSeekerDTO) throws SQLException {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setFirstName(jobSeekerDTO.getFirstName());
        jobSeeker.setLastName(jobSeekerDTO.getLastName());
        jobSeeker.setNationalId(jobSeekerDTO.getNationalId());
        jobSeeker.setDateOfBirth(jobSeekerDTO.getDateOfBirth());
        jobSeeker.setEmail(jobSeekerDTO.getEmail());
        jobSeeker.setPass(jobSeekerDTO.getPass());
        jobSeeker.setGender(jobSeekerDTO.getGender());

        if (this.mernisServiceAdapter.checkIfRealPerson(jobSeeker)) {
            final JobSeeker jobSeekerDb = jobSeekerRepository.save(jobSeeker);
            jobSeekerDTO.setId(jobSeekerDb.getId());
            logger.info("'" + jobSeekerDTO + "' is created");
            return jobSeekerDb;
        } else {
            throw new RuntimeException("kontrol et");
        }
    }

    @Override
    public List<JobSeekerDTO> getAll() {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
        List<JobSeekerDTO> jobSeekerDTOs = new ArrayList<>();
        jobSeekers.forEach(jobSeeker -> jobSeekerDTOs.add(modelMapper.map(jobSeeker, JobSeekerDTO.class)));

        logger.info("All jobs are listed");

        return jobSeekerDTOs;
    }

    @Override
    public Job getById(Long jobSeekerId) {
        //TODO
        return null;
    }

    @Override
    public Job getByEmail(String email) {
        //TODO
        return null;
    }

    @Override
    public Job getByNationalId(String nationalId) {
        //TODO
        return null;
    }

    @Override
    public Job getByFirstNameAndLastName(String firstName, String lastName) {
        //TODO
        return null;
    }

    @Override
    public Job delete(Long jobSeekerId) {
        //TODO
        return null;
    }

    @Override
    public List<JobSeekerDTO> filterByFirstNameAndLastName(String firstName, String lastName) {
        //TODO
        return null;
    }

    @Override
    public List<JobSeekerDTO> filterJobSeekersByGender(Gender gender) {
        return null;
    }

    @Override
    public List<JobSeekerDTO> filterJobSeekersByRole(LocalDate dateOfBirth) {
        return null;
    }
}
