package com.dalfatih.hrms.business.concretes;

import com.dalfatih.hrms.business.abstracts.RoleService;
import com.dalfatih.hrms.dataAccess.abstracts.RoleRepository;
import com.dalfatih.hrms.dto.RoleDTO;
import com.dalfatih.hrms.entities.concretes.Role;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleManager implements RoleService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RoleRepository roleRepository;

    @Override
    public Role addJob(RoleDTO roleDTO) {
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());
        final Role roleDb = roleRepository.save(role);
        roleDTO.setId(roleDb.getId());

        logger.info("'" + roleDTO + "' is created");
        return role;
    }
}
