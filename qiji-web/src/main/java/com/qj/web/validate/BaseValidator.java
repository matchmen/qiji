package com.qj.web.validate;

import com.qj.common.embed.ReturnResult;

/****
 * author:lqm
 * 2019-05-29
 **/
public class BaseValidator {

    public ReturnResult<String> assembleResult(boolean b, String msg) {

        return new ReturnResult<String>(b, msg);
    }

    public ReturnResult<String> ok = new ReturnResult<>(false,"OK");
}
