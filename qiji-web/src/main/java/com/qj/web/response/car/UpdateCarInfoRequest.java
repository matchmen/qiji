package com.qj.web.response.car;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/****
 * author:lqm
 * 2019-05-30
 **/
@Data
public class UpdateCarInfoRequest {

    @NotBlank(message = "型号不能为空")
    private String model;

    private String brand;

    private String carOnwerName;

    private String carOnwerPhone;

    private String description;

    @NotBlank(message = "ID不能为空")
    private Long id;

    private Long shopId;
}
