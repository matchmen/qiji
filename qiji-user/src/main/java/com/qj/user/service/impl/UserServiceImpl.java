package com.qj.user.service.impl;

import com.qj.common.embed.ReturnResult;
import com.qj.user.domain.Role;
import com.qj.user.domain.User;
import com.qj.user.mapper.RoleMapper;
import com.qj.user.mapper.UserMapper;
import com.qj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User getByUsername(String username) {

        User user = userMapper.findByUsername(username);
        if(!Objects.isNull(user)) {
            Role role = roleMapper.findById(user.getId());
            user.setRoles(Arrays.asList(role));
        }
        return user;
    }

    @Override
    public ReturnResult<User> getUserById(Long id) {

        User user = userMapper.findById(id);

        Role role = roleMapper.findById(user.getRoleId());

        user.setRoles(Arrays.asList(role));

        return new ReturnResult(true,"获取成功",user);
    }
}
