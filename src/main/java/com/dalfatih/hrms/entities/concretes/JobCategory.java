package com.dalfatih.hrms.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "job_categories")
@Data
@NoArgsConstructor
public class JobCategory {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "title", nullable = false, unique = true)
    String title;

    @Column(name = "description", nullable = false)
    String description;
}