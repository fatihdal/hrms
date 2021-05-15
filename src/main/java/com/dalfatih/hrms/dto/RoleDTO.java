package com.dalfatih.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RoleDTO {

    private Long id;
    private String roleName;
}
