package com.dalfatih.hrms.entities.abstracts;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
@RequiredArgsConstructor
//@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@NonNull
    private Long id;
}
