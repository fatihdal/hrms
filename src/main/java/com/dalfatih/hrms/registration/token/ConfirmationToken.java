package com.dalfatih.hrms.registration.token;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import com.dalfatih.hrms.entities.concretes.JobSeeker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken extends BaseEntity {

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "job_seeker_id"
    )
    private JobSeeker jobSeeker;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             JobSeeker jobSeeker) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.jobSeeker = jobSeeker;
    }
}
