package com.qj.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
@MapperScan(basePackages = {"com.qj.**.mapper"})
@SpringBootApplication(scanBasePackages = {"com.qj.**"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}