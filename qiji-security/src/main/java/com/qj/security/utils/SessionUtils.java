package com.qj.security.utils;

import com.qj.security.embed.AuthUser;
import org.springframework.security.core.context.SecurityContextHolder;

/****
 * author:lqm
 * 2019-05-29
 **/
public class SessionUtils {

    public static AuthUser getLoginUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (obj != null && obj instanceof AuthUser) {
                return (AuthUser)obj;
            }
        }
        return null;
    }

    public static Long getLoginUserId() {
        return getLoginUser().getId();
    }

    public static Long getShopId() {
        return getLoginUser().getShopId();
    }


}
