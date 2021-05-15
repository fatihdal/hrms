package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {


    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "job_category_id"/*, foreignKey = @ForeignKey(name = "fk_job_categories_id")*/)
    @NonNull
    private JobCategory jobCategory;

    @Column(name = "job_title", nullable = false, unique = true)
    @NonNull
    private String jobTitle;

    @Column(name = "job_description")
    @NonNull
    private String jobDescription;
}