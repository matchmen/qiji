package com.qj.common.utils;


import java.util.regex.Pattern;

/****
 *
 * author:lqm
 * 2019-05-23
 **/
public class QjStringUtil {

    public static boolean isNotBlank(String str){
        return str != null && !"".equals(str) && str.trim().length() > 0;
    }

    public static boolean isBlank(String str){
        return str == null || "".equals(str) || str.trim().length() > 0;
    }

    public static boolean isNumber(String str){
        return matches("^[0-9]*$",str);
    }

    public static boolean matches(String regex,String source) {
        return Pattern.matches(regex, source);
    }

}
