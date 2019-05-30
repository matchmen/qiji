package com.qj.web.controller;

import com.qj.common.embed.ReturnResult;
import com.qj.security.vo.ResultVO;
import com.qj.shop.domain.Shop;
import com.qj.shop.service.ShopService;
import com.qj.web.request.shop.GetShopInfoRequest;
import com.qj.web.request.shop.PerfectShopInfoRequest;
import com.qj.web.request.shop.ShopRegisterRequest;
import com.qj.web.response.shop.GetShopInfoResponse;
import com.qj.web.service.ShopRegisteService;
import com.qj.web.validate.ShopRequestValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
@Slf4j
@Controller
@RequestMapping(value = "/qj/shop/")
public class ShopController extends BaseController{

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopRequestValidator shopRequestValidator;

    @Autowired
    private ShopRegisteService shopRegisteService;

    @PostMapping(value = "/notNeedLogin/register")
    @ResponseBody
    public ResultVO<String> register(@RequestBody ShopRegisterRequest shopRegisterRequest) {

        ReturnResult result = shopRequestValidator.registeShopRequestValidate(shopRegisterRequest);

        if(!result.getIsSuccess()){
            return assembleResult(result);
        }
        result = shopRegisteService.registeShop(shopRegisterRequest);

        return assembleResult(result);

    }

    @ResponseBody
    @RequestMapping(value = "/getShopInfo")
    @PreAuthorize("hasPermission('/qj/shop/getShopInfo','qj')")
    public ResultVO<GetShopInfoResponse> getShopInfo(@Validated @RequestBody GetShopInfoRequest request) {

        ReturnResult<Shop> result = shopService.getShopInfo(request.getId());

        Shop shop = result.getData();

        GetShopInfoResponse response = new GetShopInfoResponse();

        BeanUtils.copyProperties(shop, response);

        return assembleResult(result.getIsSuccess(), "获取成功", response);
    }


    @ResponseBody
    @RequestMapping(value = {"/perfectShopInfo","/updateShopInfo"})
    @PreAuthorize("hasPermission('/qj/shop/perfectShopInfo','qj')")
    public ResultVO perfectShopInfo(@Validated @RequestBody PerfectShopInfoRequest request) {

        ReturnResult result = shopRequestValidator.perfectShopInfoValidate(request);

        if(!result.getIsSuccess()){
            return assembleResult(result);
        }
        Shop shop = new Shop();
        BeanUtils.copyProperties(request, shop);
        result = shopService.updateShopInfo(shop);

        return assembleResult(result);
    }

    @ResponseBody
    @RequestMapping(value = "/updateShopInfo")
    @PreAuthorize("hasPermission('/qj/shop/updateShopInfo','qj')")
    public ResultVO updateShopInfo(@Validated @RequestBody PerfectShopInfoRequest request) {

        ReturnResult result = shopRequestValidator.perfectShopInfoValidate(request);
        if(!result.getIsSuccess()){
            return assembleResult(result);
        }
        Shop shop = new Shop();
        BeanUtils.copyProperties(request, shop);
        result = shopService.updateShopInfo(shop);
        return assembleResult(result);
    }


}
