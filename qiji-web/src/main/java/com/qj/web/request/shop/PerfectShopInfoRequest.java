package com.qj.web.request.shop;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/****
 *
 * author:lqm
 * 2019-05-23
 **/
@Data
public class PerfectShopInfoRequest {

    @NotBlank
    private Long id;

    private String shopAddress;

    @Pattern(regexp = "/^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/")
    private String openShopDate;

    @Pattern(regexp = "([0-1]?[0-9]|2[0-3])-([0-5][0-9])-([0-5][0-9])$",message = "营业起始时间格式不正确")
    private String businessFromTime;

    @Pattern(regexp = "([0-1]?[0-9]|2[0-3])-([0-5][0-9])-([0-5][0-9])$",message = "营业结束时间格式不正确")
    private String businessEndTime;

    private String miantenanceCarBrand;

    private String connectPhone;
}
