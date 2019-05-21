package com.qj.security.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qj.common.utils.DateUtil;
import com.qj.security.embed.AuthUser;
import com.qj.security.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/****
 * author:lqm
 * 2019-05-08
 **/
@Component
@Slf4j
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        AuthUser authUser =  (AuthUser) authentication.getPrincipal();

        log.info("用户:{}在{}进行登录成功!",authUser.getUsername(), DateUtil.format(new Date(),DateUtil.STANDARD_PATTERN));

        ResultVO resultVO = new ResultVO("SUCCESS","登录成功");

        response.setContentType("application/json;charset=UTF-8");

        response.getWriter().write(objectMapper.writeValueAsString(resultVO));

    }
}
