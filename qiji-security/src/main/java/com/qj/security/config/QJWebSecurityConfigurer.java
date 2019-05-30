package com.qj.security.config;

import com.qj.security.handle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;


/****
 *
 * author:lqm
 * 2019-05-07
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class QJWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserLoginSuccessHandler userLoginSuccessHandler;

    @Autowired
    private UserLoginFailureHandler userLoginFailureHandler;

    @Autowired
    private UserLogoutSuccessHandler userLogoutSuccessHandler;

    @Autowired
    private QJAccessDeniedHandler qjAccessDeniedHandler;

    @Autowired
    private QJAuthenticationProvider qjAuthenticationProvider;

//    @Bean
//    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
//        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
//        handler.setPermissionEvaluator(new QJPermissionEvaluator());
//        return handler;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这里可启用我们自己的登陆验证逻辑
        auth.authenticationProvider(qjAuthenticationProvider);
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                //"/login"不进行权限验证
                .antMatchers("/login","/qj/shop/notNeedLogin/register").permitAll()
                .anyRequest().authenticated()  //其他的需要登陆后才能访问
                .and()
                .formLogin()
                //loginProcessingUrl用于指定前后端分离的时候调用后台登录接口的名称
                .loginProcessingUrl("/login")
                //配置登录成功的自定义处理类
                .successHandler(userLoginSuccessHandler)
                //配置登录失败的自定义处理类
                .failureHandler(userLoginFailureHandler)
                .and()
                //loginProcessingUrl用于指定前后端分离的时候调用后台注销接口的名称
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler(userLogoutSuccessHandler)
                .and()
                //配置没有权限的自定义处理类
                .exceptionHandling().accessDeniedHandler(qjAccessDeniedHandler)
                .and()
                .cors()//新加入
                .and()
                .csrf().disable();// 取消跨站请求伪造防护
    }


}
