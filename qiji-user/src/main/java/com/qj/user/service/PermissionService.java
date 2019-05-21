package com.qj.user.service;

import com.qj.user.domain.Permission;

import java.util.List;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
public interface PermissionService {


    List<Permission> getPerssionsByRoleId(Long roleId);

}
