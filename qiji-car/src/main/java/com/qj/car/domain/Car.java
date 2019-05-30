package com.qj.car.domain;

import lombok.Data;

/****
 * author:lqm
 * 2019-05-29
 **/
@Data
public class Car {

    private Long id;

    private Long shopId;

    private String model;

    private String brand;

    private String carOnwerName;

    private String carOnwerPhone;

    private String description;

}
