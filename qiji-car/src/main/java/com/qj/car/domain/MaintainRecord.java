package com.qj.car.domain;

import lombok.Data;

/****
 * author:lqm
 * 2019-05-30
 **/
@Data
public class MaintainRecord {

    private Long id;

    private Long carId;

    private Long shopId;

    private Long persionInchangeId;

    private String maintainDate;

    private String maintainTitle;

    private String maintainInfo;

}
