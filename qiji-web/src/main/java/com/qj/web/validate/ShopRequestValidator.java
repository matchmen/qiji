package com.qj.web.validate;

import com.qj.common.embed.ReturnResult;
import com.qj.common.utils.DateUtil;
import com.qj.common.utils.QjStringUtil;
import com.qj.shop.domain.Shop;
import com.qj.shop.service.ShopService;
import com.qj.web.request.shop.PerfectShopInfoRequest;
import com.qj.web.request.shop.ShopRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/****
 * author:lqm
 * 2019-05-21
 **/
@Component
public class ShopRequestValidator extends  BaseValidator{

    @Autowired
    private ShopService shopService;

    public ReturnResult<String> registeShopRequestValidate(ShopRegisterRequest request) {

        ReturnResult<Shop> returnResult = shopService.getShopInfoByShopName(request.getShopName());

        if(!Objects.isNull(returnResult.getData())){
            return assembleResult(false,"店铺名称已经存在!");
        }

        if(!request.getPassword1().equals(request.getPassword2())){
            return assembleResult(false,"两次输入密码不一致!");
        }

        return assembleResult(true,"OK");
    }

    public ReturnResult<String> perfectShopInfoValidate(PerfectShopInfoRequest request) {

        ReturnResult<Shop> returnResult = shopService.getShopInfo(request.getId());
        if(Objects.isNull(returnResult.getData())){
            return assembleResult(false, "店铺不存在");
        }

        if(QjStringUtil.isNotBlank(request.getBusinessEndTime()) && QjStringUtil.isNotBlank(request.getBusinessEndTime())){

            Date dateF = DateUtil.format(request.getBusinessFromTime());
            Date dateE = DateUtil.format(request.getBusinessEndTime());
            if(dateF.after(dateE)){
                return assembleResult(false, "营业起始时间不能晚于结束时间");
            }
        }
        return assembleResult(true, "OK");
    }


}
