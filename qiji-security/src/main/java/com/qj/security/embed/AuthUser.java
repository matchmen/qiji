package com.qj.security.embed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/****
 *
 * author:lqm
 * 2019-05-07
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser implements UserDetails {

    private String username;

    private String password;

    private Long shopId;

    private Long id;

    private List<String> roleNames;

    private List<QJGrantedAuthority> qjGrantedAuthorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return qjGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
