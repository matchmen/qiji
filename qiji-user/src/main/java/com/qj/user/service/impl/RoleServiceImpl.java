package com.qj.user.service.impl;

import com.qj.user.domain.Role;
import com.qj.user.mapper.RoleMapper;
import com.qj.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 *
 * author:lqm
 * 2019-05-23
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleMapper.selectByRoleName(roleName);
    }

    @Override
    public Role getRoleByRoleCode(String roleCode) {
        return roleMapper.selectByRoleCode(roleCode);
    }

}
