package com.dalfatih.hrms.entities.abstracts;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
