package com.qj.common.utils;

import java.util.Date;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
public class IdGenerator {


    public static Long generateId(){


        Date now = new Date();

        String yyyyMMddHHmmss = DateUtil.format(now, DateUtil.yyyyMMddHHmmss);

        int redom = (int) ((Math.random() * 9 + 1) * 10000);

        yyyyMMddHHmmss += redom;

        return Long.valueOf(yyyyMMddHHmmss);
    }

    public static void main(String[] args) {
        System.out.println(generateId());
    }


}
