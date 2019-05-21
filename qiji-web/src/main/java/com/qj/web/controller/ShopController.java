package com.qj.web.controller;

import com.qj.shop.service.ShopService;
import com.qj.web.request.shop.ShopRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
@Slf4j
@Controller
@RequestMapping(value = "/qj/shop/")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/register")
    @ResponseBody
    public void register(@Validated ShopRegisterRequest shopRegisterRequest) {




    }

}
