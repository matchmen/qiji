package com.qj.web.response.shop;

import lombok.Data;

/****
 *
 * author:lqm
 * 2019-05-23
 **/
@Data
public class GetShopInfoResponse {

    private Long id;

    private String shopName;

    private String shopAddress;

    private String openShopDate;

    private String businessFromTime;

    private String businessEndTime;

    private String miantenanceCarBrand;

    private String connectPhone;

}
