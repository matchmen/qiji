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
public class Role {

    private Long id;

    private String roleName;

    private String description;

    private String roleCode;
}
