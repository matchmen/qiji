package com.qj.web.service;

import com.qj.common.embed.ReturnResult;
import com.qj.web.request.shop.ShopRegisterRequest;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
public interface ShopRegisteService {


    ReturnResult<String> registeShop(ShopRegisterRequest request);


}
