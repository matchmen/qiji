package com.qj.car.service;

import com.qj.car.domain.Car;

import java.util.List;

/****
 *
 * author:lqm
 * 2019-05-29
 **/
public interface CarService {

    void addCar(Car car);

    Car getCarById(Long id,Long shopId);

    Car getCarByModel(String model,Long shopId);

    void updateCar(Car car);

    List<Car> getCarList(Long shopId,String model, String brand, String carOnwerName);

}
