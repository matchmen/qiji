package com.qj.web.request.shop;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/****
 *
 * author:lqm
 * 2019-05-23
 **/
@Data
public class GetShopInfoRequest {

    @NotBlank(message = "ID不能为空")
    private Long id;

}
