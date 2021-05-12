package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.dto.JobDTO;

import java.util.List;

public interface JobService {

    List<JobDTO> getAll();
}
