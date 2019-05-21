package com.qj.user.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
@Data
@ToString
public class User {

    private Long id;

    private String username;

    private String password;

    private Long roleId;

    private List<Role> roles;


}
