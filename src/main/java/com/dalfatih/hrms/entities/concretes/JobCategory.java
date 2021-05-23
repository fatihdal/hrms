package com.dalfatih.hrms.entities.concretes;

import com.dalfatih.hrms.entities.abstracts.BaseEntity;
import lombok.*;
import org.eclipse.persistence.annotations.PrimaryKey;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "job_categories", uniqueConstraints = @UniqueConstraint
        (columnNames = "title", name = "uk_job_category_title"))
public class JobCategory extends BaseEntity {

    @NonNull
    @Column(name = "title", nullable = false)
    private String categoryTitle;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;
}