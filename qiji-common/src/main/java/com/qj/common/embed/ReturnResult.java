package com.qj.common.embed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
@Data
@ToString
@AllArgsConstructor
public class ReturnResult<T> {

    private Boolean isSuccess;

    private String message;

    private T data;

    public ReturnResult(Boolean isSuccess, String message) {
        this.message = message;
        this.isSuccess = isSuccess;
    }
}
