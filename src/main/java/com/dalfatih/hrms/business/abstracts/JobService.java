package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.dto.JobDTO;
import com.dalfatih.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {

    Job addJob(JobDTO jobDTO);

    List<JobDTO> getAll();

    JobDTO getById(Long jobId);

    Job delete(Long jobId);

    List<JobDTO> filterByTitleOrDescription(String keyword);
}