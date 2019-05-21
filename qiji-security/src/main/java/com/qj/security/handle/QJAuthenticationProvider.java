package com.qj.security.handle;

import com.qj.common.embed.ReturnResult;
import com.qj.security.embed.AuthUser;
import com.qj.security.embed.QJGrantedAuthority;
import com.qj.security.service.QJUserDetailServiceImpl;
import com.qj.user.domain.Permission;
import com.qj.user.domain.User;
import com.qj.user.service.PermissionService;
import com.qj.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/****
 * 实现自己的AuthenticationProvider类，用来自定义用户校验机制
 * author:lqm
 * 2019-05-08
 **/
@Component
@Slf4j
public class QJAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private QJUserDetailServiceImpl qjUserDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        AuthUser authUser = (AuthUser) qjUserDetailService.loadUserByUsername(userName);

        if (Objects.isNull(authUser)) {
            throw new BadCredentialsException("用户名不存在");
        }
        // 这里我们还要判断密码是否正确，这里我们的密码使用BCryptPasswordEncoder进行加密的
        if (!new BCryptPasswordEncoder().matches(password, authUser.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(authUser, password, authUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
