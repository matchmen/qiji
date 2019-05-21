package com.qj.user.mapper;

import com.qj.user.domain.Role;
import org.apache.ibatis.annotations.Param;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
public interface RoleMapper {

    Role findById(@Param("id") Long id);


}
