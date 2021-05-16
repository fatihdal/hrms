package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.dto.JobDTO;
import com.dalfatih.hrms.dto.RoleDTO;
import com.dalfatih.hrms.entities.concretes.Job;
import com.dalfatih.hrms.entities.concretes.Role;

import java.util.List;

public interface RoleService {

    Role addJob(RoleDTO roleDTO);

    List<RoleDTO> getAll();

    Role getById(Long roleId);

    Role delete(Long roleId);

    List<RoleDTO> filterByTitleOrDescription(String keyword);
}
