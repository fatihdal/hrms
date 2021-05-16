package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.dto.JobSeekerDTO;
import com.dalfatih.hrms.entities.concretes.Gender;
import com.dalfatih.hrms.entities.concretes.Job;
import com.dalfatih.hrms.entities.concretes.JobSeeker;

import javax.validation.constraints.Email;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface JobSeekerService {

    JobSeeker addJobSeeker(JobSeekerDTO jobSeekerDTO) throws SQLException;

    List<JobSeekerDTO> getAll();

    Job getById(Long jobSeekerId);

    Job getByEmail(String email);

    Job getByNationalId(String nationalId);

    Job getByFirstNameAndLastName(String firstName, String lastName);

    List<JobSeekerDTO> filterByFirstNameAndLastName(String firstName, String lastName);

    List<JobSeekerDTO> filterJobSeekersByGender(Gender gender);

    List<JobSeekerDTO> filterJobSeekersByRole(LocalDate dateOfBirth);

    Job delete(Long jobSeekerId);
}
