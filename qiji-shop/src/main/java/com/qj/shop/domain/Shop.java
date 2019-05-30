package com.qj.shop.domain;

import lombok.Data;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
@Data
public class Shop {

    private Long id;

    private String shopName;

    private String shopAddress;

    private String openShopDate;

    private String businessFromTime;

    private String businessEndTime;

    private String miantenanceCarBrand;

    private String connectPhone;

}
