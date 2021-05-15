package com.dalfatih.hrms.business.abstracts;

import com.dalfatih.hrms.dto.RoleDTO;
import com.dalfatih.hrms.entities.concretes.Role;

public interface RoleService {

    Role addJob(RoleDTO roleDTO);
}
