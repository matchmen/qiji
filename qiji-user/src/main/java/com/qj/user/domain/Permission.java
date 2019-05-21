package com.qj.user.domain;

import lombok.Data;
import lombok.ToString;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
@Data
@ToString
public class Permission {

    private Long id;

    private String description;

    private String url;

}
