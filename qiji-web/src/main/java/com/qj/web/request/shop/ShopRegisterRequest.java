package com.qj.web.request.shop;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
@Data
public class ShopRegisterRequest {

    @NotBlank(message = "店铺名称不能为空")
    @Length(max = 20,message = "店铺名称长度不能超过20")
    private String shopName;

    @NotBlank(message = "店主姓名不能为空")
    @Length(max = 20,message = "店主姓名长度不能超过20")
    private String ShopOwnerName;

    @NotBlank(message = "店主手机不能为空")
    private String phoneNumber;

    @NotBlank(message = "密码不能为空")
    private String password1;

    @NotBlank(message = "再次输入密码不能为空")
    private String password2;

}
