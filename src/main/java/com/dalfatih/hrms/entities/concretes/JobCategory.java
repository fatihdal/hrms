package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "job_categories")
public class JobCategory extends BaseEntity {

    @Column(name = "title", nullable = false, unique = true)
    @NonNull
    private String categoryTitle;

    @Column(name = "description", nullable = false)
    @NonNull
    private String description;
}