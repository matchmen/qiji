package com.qj.user.mapper;

import com.qj.user.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
public interface PermissionMapper {

    List<Permission> findByRoleId(@Param("roleId") Long roleId);

}
