package com.qj.web.request.car;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/****
 * author:lqm
 * 2019-05-30
 **/
@Data
public class UpdateMaintainRecordRequest {

    private Long id;

    private Long carId;

    private Long shopId;

    private Long persionInchangeId;

    private String maintainDate;

    @NotBlank(message = "主题不能为空")
    private String maintainTitle;

    @NotBlank(message = "修改内容不能为空")
    private String maintainInfo;

}
