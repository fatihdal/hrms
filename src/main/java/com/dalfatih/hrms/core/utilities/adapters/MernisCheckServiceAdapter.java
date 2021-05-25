package com.dalfatih.hrms.core.utilities.adapters;

import com.dalfatih.hrms.business.abstracts.JobSeekerCheckService;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;
import tr.gov.nvi.tckimlik.ws.KPSPublic;

import java.util.Locale;

@Service("")
public class MernisCheckServiceAdapter implements JobSeekerCheckService {
    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
        KPSPublic service = new KPSPublic();
        return service.getKPSPublicSoap().tcKimlikNoDogrula(
                Long.parseLong(jobSeeker.getNationalId()), jobSeeker.getFirstName()
                        .toUpperCase(Locale.ROOT), jobSeeker.getLastName()
                        .toUpperCase(Locale.ROOT), jobSeeker.getDateOfBirth().getYear());
    }

}