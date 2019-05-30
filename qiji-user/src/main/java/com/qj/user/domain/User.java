package com.qj.user.domain;

import lombok.Data;
import lombok.ToString;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
@Data
@ToString
public class User {

    private Long id;

    private Long shopId;

    private String name;

    private String phoneNumber;

    private String password;

    private Long roleId;

    private Role role;


}
