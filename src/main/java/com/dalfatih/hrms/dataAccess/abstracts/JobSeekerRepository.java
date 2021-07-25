package com.dalfatih.hrms.dataAccess.abstracts;

import com.dalfatih.hrms.core.utilities.results.SuccessResult;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

    Optional<JobSeeker> findByEmail(String email);

    Optional<JobSeeker> findByNationalId(String nationalId);

    Optional<JobSeeker>findByPhone(String phone);

    @Transactional
    @Modifying
    @Query("UPDATE JobSeeker a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableJobSeeker(String email);
}