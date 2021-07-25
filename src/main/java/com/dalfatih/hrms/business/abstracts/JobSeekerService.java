package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.dtos.JobSeekerDto;
import com.dalfatih.hrms.entities.concretes.Gender;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface JobSeekerService extends UserDetailsService {

    DataResult<JobSeeker> addJobSeeker(JobSeekerDto jobSeekerDto) throws SQLException;

    String signUpJobSeeker(JobSeekerDto jobSeekerDto);

    public int enableJobSeeker(String email);

    DataResult<List<JobSeeker>> getAll();

    DataResult<JobSeeker> getById(Long jobSeekerId);

    DataResult<JobSeeker> getByEmail(String email);

    DataResult<JobSeeker> getByNationalId(String nationalId);

    DataResult<JobSeeker> getByFirstNameAndLastName(String firstName, String lastName);

    DataResult<List<JobSeeker>> filterByFirstNameAndLastName(String firstName, String lastName);

    DataResult<List<JobSeeker>> filterJobSeekersByGender(Gender gender);

    DataResult<List<JobSeeker>> filterJobSeekersByRole(LocalDate dateOfBirth);

    DataResult<JobSeeker> delete(Long jobSeekerId);
}
