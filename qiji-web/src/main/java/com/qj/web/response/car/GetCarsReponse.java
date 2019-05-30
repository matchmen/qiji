package com.qj.web.response.car;

import lombok.Data;

/****
 * author:lqm
 * 2019-05-29
 **/
@Data
public class GetCarsReponse {

    private Long id;

    private String model;

    private String brand;

    private String carOnwerName;

    private String carOnwerPhone;

}
