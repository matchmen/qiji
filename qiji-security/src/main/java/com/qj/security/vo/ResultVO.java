package com.qj.security.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/****
 *
 * author:lqm
 * 2019-05-07
 **/
@Data
@ToString
public class ResultVO<T> {

    private String result;

    private String message;

    private T data;

    public ResultVO(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResultVO(String result, String message,T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public ResultVO() {}

}
