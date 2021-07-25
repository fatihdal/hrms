package com.dalfatih.hrms.registration;

import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.dtos.JobSeekerDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationManager registrationManager;

    @RequestMapping(method = RequestMethod.POST,value = "/jobseeker")
    public DataResult<String> register (@Valid @RequestBody JobSeekerDto jobSeekerDto)throws Exception{   //@Valid may change
        return registrationManager.register(jobSeekerDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationManager.confirmToken(token);
    }

}
