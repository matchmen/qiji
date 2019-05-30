package com.qj.user.service;

import com.qj.user.domain.Role;

/****
 *
 * author:lqm
 * 2019-05-23
 **/
public interface RoleService {

    Role getRoleByRoleName(String roleName);

    Role getRoleByRoleCode(String roleCode);



}
