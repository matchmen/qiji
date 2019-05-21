package com.qj.web.response.user;

import lombok.Data;
import lombok.ToString;


/****
 *
 * author:lqm
 * 2019-05-08
 **/
@Data
@ToString
public class GetUserByIdResponse {

    private Long id;

    private String username;

    private String roleName;

}
