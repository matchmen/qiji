package com.qj.user.service.impl;

import com.qj.user.domain.Permission;
import com.qj.user.mapper.PermissionMapper;
import com.qj.user.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPerssionsByRoleId(Long roleId) {

        return permissionMapper.findByRoleId(roleId);
    }
}
