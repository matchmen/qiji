package com.qj.web.request.car;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/****
 * author:lqm
 * 2019-05-29
 **/
@Data
public class AddCarRequest {

    @NotBlank(message = "汽车型号不能为空")
    private String model;

    private String brand;

    private String carOnwerName;

    private String carOnwerPhone;

    private String description;

    private Long shopId;

}
