package com.qj.web.controller;

import com.qj.common.embed.ReturnResult;
import com.qj.security.utils.SessionUtils;
import com.qj.security.vo.ResultVO;
import com.qj.web.enums.ResponseCode;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
public abstract class BaseController {


    public ResultVO success = new ResultVO(ResponseCode.SUCCESS.name(),"成功");

    public ResultVO failed = new ResultVO(ResponseCode.FAILED.name(),"失败");

    public ResultVO assembleResult(ReturnResult result) {

        return new ResultVO(result.getIsSuccess()?ResponseCode.SUCCESS.name():ResponseCode.FAILED.name(),
                result.getMessage(), result.getData());

    }

    public ResultVO assembleResult(boolean isSuccess,String mag,Object data) {

        return new ResultVO(isSuccess?ResponseCode.SUCCESS.name():ResponseCode.FAILED.name(), mag, data);
    }

    public Long getShopId() {
        return SessionUtils.getShopId();
    }

    public Long getUserId() {
        return SessionUtils.getLoginUserId();
    }

}
