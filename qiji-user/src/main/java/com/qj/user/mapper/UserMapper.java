package com.qj.user.mapper;

import com.qj.user.domain.User;
import org.apache.ibatis.annotations.Param;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
public interface UserMapper {

    User findByUsername(@Param("username") String username);

    User findById(@Param("id") Long id);

    void insertUser(User user);


}
