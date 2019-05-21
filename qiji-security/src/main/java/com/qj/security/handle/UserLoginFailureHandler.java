package com.qj.security.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qj.common.utils.DateUtil;
import com.qj.security.embed.AuthUser;
import com.qj.security.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
@Component
@Slf4j
public class UserLoginFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        log.info("用户登录失败!");

        ResultVO resultVO = new ResultVO("FAILED","用户名或密码不正确");

        response.setContentType("application/json;charset=UTF-8");

        response.getWriter().write(objectMapper.writeValueAsString(resultVO));

    }
}
