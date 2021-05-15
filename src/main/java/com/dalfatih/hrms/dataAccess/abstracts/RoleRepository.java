package com.dalfatih.hrms.dataAccess.abstracts;

import com.dalfatih.hrms.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
