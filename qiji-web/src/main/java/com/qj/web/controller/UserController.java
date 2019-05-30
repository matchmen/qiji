package com.qj.web.controller;

import com.qj.common.embed.ReturnResult;
import com.qj.security.vo.ResultVO;
import com.qj.user.domain.User;
import com.qj.user.service.UserService;
import com.qj.web.enums.ResponseCode;
import com.qj.web.response.user.GetUserByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById")
    @ResponseBody
    @PreAuthorize("hasPermission('/user/getUserById','qj')")
    public ResultVO<GetUserByIdResponse> getUserById(@RequestParam("userId") Long id) {

        ReturnResult<User> result = userService.getUserById(id);

        if(!result.getIsSuccess()){
            return new ResultVO<>(ResponseCode.FAILED.name(), result.getMessage());
        }

        GetUserByIdResponse response = new GetUserByIdResponse();

        User user = result.getData();
        response.setId(user.getId());
        response.setUsername(user.getPhoneNumber());
        response.setRoleName(user.getRole().getRoleName());

        return new ResultVO<>(ResponseCode.SUCCESS.name(), "获取成功", response);

    }

    @GetMapping("/updatePassword")
    @PreAuthorize("hasPermission('/user/updatePassword','qj')")
    @ResponseBody
    public ResultVO updatePassword(@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword){

        return new ResultVO(ResponseCode.SUCCESS.name(), "成功");

    }

}
