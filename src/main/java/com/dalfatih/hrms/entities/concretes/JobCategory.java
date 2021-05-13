package com.dalfatih.hrms.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "job_categories")
public class JobCategory {

    @Id
    @Column(name = "job_category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, unique = true)
    private String categoryTitle;

    @Column(name = "description", nullable = false)
    private String description;
}