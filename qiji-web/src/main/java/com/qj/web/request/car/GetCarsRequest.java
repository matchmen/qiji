package com.qj.web.request.car;

import lombok.Data;

/****
 * author:lqm
 * 2019-05-29
 **/
@Data
public class GetCarsRequest {

    private String model;

    private String brand;

    private String carOnwerName;
}
