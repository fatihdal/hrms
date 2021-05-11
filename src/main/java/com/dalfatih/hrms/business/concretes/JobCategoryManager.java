package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.JobCategoryService;
import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobCategoryManager implements JobCategoryService {

    private JobCategoryRepository jobCategoryRepository;

    @Override
    public List<JobCategory> getAll() {
        return null;
    }
}