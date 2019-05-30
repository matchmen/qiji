package com.qj.car.service.impl;

import com.qj.car.domain.Car;
import com.qj.car.mapper.CarMapper;
import com.qj.car.service.CarService;
import com.qj.common.utils.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/****
 * author:lqm
 * 2019-05-29
 **/
@Slf4j
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    @Transactional
    public void addCar(Car car) {
        car.setId(IdGenerator.generateId());
        carMapper.insertCar(car);
    }

    @Override
    public Car getCarById(Long id,Long shopId) {
        return carMapper.selectById(id,shopId);
    }

    @Override
    public Car getCarByModel(String model,Long shopId) {
        return carMapper.selectByModel(model, shopId);
    }

    @Override
    public void updateCar(Car car) {
        carMapper.updateCar(car);
    }

    @Override
    public List<Car> getCarList(Long shopId,String model, String brand, String carOnwerName) {
        return carMapper.selectCars(shopId,model, brand, carOnwerName);
    }
}
