package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.JobSeekerCheckService;
import com.dalfatih.hrms.business.abstracts.JobSeekerService;
import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.core.utilities.results.SuccessDataResult;
import com.dalfatih.hrms.dataAccess.abstracts.JobSeekerRepository;
import com.dalfatih.hrms.dtos.JobSeekerDto;
import com.dalfatih.hrms.entities.concretes.Gender;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import com.dalfatih.hrms.entities.concretes.Role;
import com.dalfatih.hrms.exception.CitizenNotVerifiedException;
import com.dalfatih.hrms.exception.RecordNotFoundException;
import com.dalfatih.hrms.registration.token.ConfirmationToken;
import com.dalfatih.hrms.registration.token.ConfirmationTokenManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class JobSeekerManager implements JobSeekerService {


    private final ModelMapper modelMapper = new ModelMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JobSeekerCheckService jobSeekerCheckService; //Fake Mernis Check Service
    private final JobSeekerRepository jobSeekerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenManager confirmationTokenManager;

    @Override
    public DataResult<JobSeeker> addJobSeeker(JobSeekerDto jobSeekerDto) {

        if (!jobSeekerCheckService.checkIfRealPerson(jobSeekerDto)) throw new CitizenNotVerifiedException("");
        JobSeeker jobSeeker = modelMapper.map(jobSeekerDto, JobSeeker.class);
        jobSeekerRepository.save(jobSeeker);

        logger.info(jobSeeker.getId() + " " + jobSeeker.getFirstName() + " " + jobSeeker.getLastName() + " is created");

        return new SuccessDataResult<>("Job seeker is created");
    }

    @Override
    public String signUpJobSeeker(JobSeekerDto jobSeekerDto) {
        boolean userExists = jobSeekerRepository
                .findByEmail(jobSeekerDto.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(jobSeekerDto.getPassword());

        jobSeekerDto.setPassword(encodedPassword);
        JobSeeker jobSeeker = modelMapper.map(jobSeekerDto, JobSeeker.class);
        jobSeeker.setRole(Role.USER);
        jobSeekerRepository.save(jobSeeker);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                jobSeeker
        );

        confirmationTokenManager.saveConfirmationToken(
                confirmationToken);

        //TODO: SEND EMAIL

        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return jobSeekerRepository.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("email"));
    }

    public int enableJobSeeker(String email) {
        return jobSeekerRepository.enableJobSeeker(email);
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {

        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();

        logger.info("All job seekers are listed");

        return new SuccessDataResult<>(jobSeekers, "All job seekers are listed");
    }

    @Override
    public DataResult<JobSeeker> getById(Long jobSeekerId) {
        //TODO
        return null;
    }

    @Override
    public DataResult<JobSeeker> getByEmail(String email) {
        //TODO
        return null;
    }

    @Override
    public DataResult<JobSeeker> getByNationalId(String nationalId) {
        //TODO
        return null;
    }

    @Override
    public DataResult<JobSeeker> getByFirstNameAndLastName(String firstName, String lastName) {
        //TODO
        return null;
    }

    @Override
    public DataResult<JobSeeker> delete(Long jobSeekerId) {
        //TODO
        return null;
    }

    @Override
    public DataResult<List<JobSeeker>> filterByFirstNameAndLastName(String firstName, String lastName) {
        //TODO
        return null;
    }

    @Override
    public DataResult<List<JobSeeker>> filterJobSeekersByGender(Gender gender) {
        return null;
    }

    @Override
    public DataResult<List<JobSeeker>> filterJobSeekersByRole(LocalDate dateOfBirth) {
        return null;
    }
}
