package com.dalfatih.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_category_id", foreignKey = @ForeignKey(name = "fk_job_category_id")/*,referencedColumnName = "id"*/)
    private JobCategory jobCategoryId;

    @Column(name = "job_title", nullable = false, unique = true)
    private String jobTitle;

    @Column(name = "job_description")
    private String jobDescription;
}