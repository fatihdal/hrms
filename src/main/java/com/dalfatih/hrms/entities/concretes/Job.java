package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "jobs",uniqueConstraints = @UniqueConstraint(columnNames = "job_title",name = "uk_job_title"))
public class Job extends BaseEntity {

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "job_category_id", foreignKey = @ForeignKey(name = "fk_job_category_id"))
    private JobCategory jobCategory;

    @NonNull
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "job_description")
    private String jobDescription;
}