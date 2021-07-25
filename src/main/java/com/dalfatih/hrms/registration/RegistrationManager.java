package com.dalfatih.hrms.registration;

import com.dalfatih.hrms.business.abstracts.JobSeekerService;
import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.core.utilities.results.SuccessDataResult;
import com.dalfatih.hrms.dtos.JobSeekerDto;
import com.dalfatih.hrms.registration.token.ConfirmationToken;
import com.dalfatih.hrms.registration.token.ConfirmationTokenManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationManager {

    private final EmailValidator emailValidator;
    private final JobSeekerService jobSeekerService;
    private final ConfirmationTokenManager confirmationTokenManager;

    public DataResult<String> register(JobSeekerDto jobSeekerDto) {

       /* boolean isValidEmail = emailValidator.test(jobSeekerDto.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }*/
        JobSeekerDto jobSeekerDto1 = JobSeekerDto.builder()
                .firstName(jobSeekerDto.getFirstName())
                .lastName(jobSeekerDto.getLastName())
                .email(jobSeekerDto.getEmail())
                .password(jobSeekerDto.getPassword())
                .gender(jobSeekerDto.getGender())
                .dateOfBirth(jobSeekerDto.getDateOfBirth())
                .nationalId(jobSeekerDto.getNationalId())
                .phone(jobSeekerDto.getPhone()).build();
        String token = jobSeekerService.signUpJobSeeker(
                jobSeekerDto1);

        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;

        System.out.println(link);

        /*emailSender.send(
                request.getEmail(),
                buildEmail(request.getFirstName(), link));*/

        return new SuccessDataResult<String>(token);
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenManager
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenManager.setConfirmedAt(token);
        jobSeekerService.enableJobSeeker(
                confirmationToken.getJobSeeker().getEmail());
        return "confirmed";
    }
}
