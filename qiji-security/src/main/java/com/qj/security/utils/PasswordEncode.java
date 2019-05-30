package com.qj.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/****
 * author:lqm
 * 2019-05-21
 **/
public class PasswordEncode {


    public static String encode(String password) {
       return new BCryptPasswordEncoder().encode(password);
    }

}
