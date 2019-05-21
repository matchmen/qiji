package com.qj.security.handle;

import com.qj.security.embed.AuthUser;
import com.qj.security.embed.QJGrantedAuthority;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
@Component
public class QJPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object o1) {

        // 获得loadUserByUsername()方法的结果
        AuthUser user = (AuthUser)authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的权限
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        // 遍历用户权限进行判定
        for(GrantedAuthority authority : authorities) {

            QJGrantedAuthority qjGrantedAuthority = (QJGrantedAuthority) authority;

            String url = qjGrantedAuthority.getAuthority();

            // 如果访问的Url和权限用户符合的话，返回true
            if(targetUrl.equals(url)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
