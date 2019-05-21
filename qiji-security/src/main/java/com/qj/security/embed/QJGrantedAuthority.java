package com.qj.security.embed;

import org.springframework.security.core.GrantedAuthority;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
public class QJGrantedAuthority implements GrantedAuthority {

    private String url;

    public QJGrantedAuthority(String url) {
        this.url = url;

    }

    @Override
    public String getAuthority() {
        return this.url;
    }


}
