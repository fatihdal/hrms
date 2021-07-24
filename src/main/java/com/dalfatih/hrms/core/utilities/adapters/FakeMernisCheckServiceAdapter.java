package com.dalfatih.hrms.core.utilities.adapters;

import com.dalfatih.hrms.business.abstracts.JobSeekerCheckService;
import com.dalfatih.hrms.dtos.JobSeekerDto;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service("jobSeekerCheckService")
public class FakeMernisCheckServiceAdapter implements JobSeekerCheckService {
    @Override
    public boolean checkIfRealPerson(JobSeekerDto jobSeekerDto) {
        String identityNumber = jobSeekerDto.getNationalId();

        if (identityNumber.length() != 11 || identityNumber.charAt(0) == '0') {
            return false;
        }
        int oddSum = 0, evenSum = 0, controlDigit = 0;
        for (int i = 0; i <= 8; i++) {
            if (i % 2 == 0) {
                oddSum += Character.getNumericValue(identityNumber.charAt(i));

            } else {
                evenSum += Character.getNumericValue(identityNumber.charAt(i));
            }
        }
        controlDigit = (oddSum * 7 - evenSum) % 10;
        if (Character.getNumericValue(identityNumber.charAt(9)) != controlDigit) {
            return false;
        }
        if (Character.getNumericValue(identityNumber.charAt(10)) != (controlDigit + evenSum + oddSum) % 10) {
            return false;
        }
        return true;
    }
}