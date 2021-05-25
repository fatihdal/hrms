package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.core.utilities.results.DataResult;
import com.dalfatih.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {

    DataResult<Job> addJob(Job job);

    DataResult<List<Job>> getAll();

    DataResult<Job> getById(Long jobId);

    DataResult<Job> delete(Long jobId);

    DataResult<List<Job>> filterByTitleOrDescription(String keyword);
}