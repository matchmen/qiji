package com.qj.web.response.car;

import lombok.Data;

/****
 * author:lqm
 * 2019-05-30
 **/
@Data
public class GetMaintainRecordResponse {


    private Long id;

    private Long carId;

    private Long persionInchangeId;

    private String maintainDate;

    private String maintainTitle;

    private String maintainInfo;

}
