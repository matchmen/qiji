package com.qj.security.service;

import com.qj.security.embed.AuthUser;
import com.qj.security.embed.QJGrantedAuthority;
import com.qj.user.domain.Permission;
import com.qj.user.domain.User;
import com.qj.user.service.PermissionService;
import com.qj.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/****
 *
 * author:lqm
 * 2019-05-09
 **/
@Slf4j
@Component
public class QJUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByUsername(username);

        if(Objects.isNull(user)){
            return null;
        }

        List<Permission> permissionList = permissionService.getPerssionsByRoleId(user.getRoleId());

        List<QJGrantedAuthority> qjGrantedAuthorities = new ArrayList<>();

        permissionList.stream().forEach(permission -> qjGrantedAuthorities.add(new QJGrantedAuthority(permission.getUrl())));

        return assembleAuthUser(user,qjGrantedAuthorities);
    }

    private AuthUser assembleAuthUser(User user, List<QJGrantedAuthority> qjGrantedAuthorities) {

        AuthUser authUser = new AuthUser();

        authUser.setPassword(user.getPassword());

        authUser.setId(user.getId());

        authUser.setShopId(user.getShopId());

        authUser.setUsername(user.getPhoneNumber());

        authUser.setQjGrantedAuthorities(qjGrantedAuthorities);

        return authUser;
    }
}
