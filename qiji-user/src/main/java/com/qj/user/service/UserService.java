package com.qj.user.service;

import com.qj.common.embed.ReturnResult;
import com.qj.user.domain.User;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
public interface UserService {

    User getByUsername(String username);

    ReturnResult<User> getUserById(Long id);


}
