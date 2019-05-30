package com.qj.car.mapper;

import com.qj.car.domain.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/****
 * author:lqm
 * 2019-05-29
 **/
public interface CarMapper {

    int insertCar(Car car);

    void updateCar(Car car);

    Car selectById(@Param("id") Long id,@Param("shopId") Long shopId);

    Car selectByModel(@Param("model") String model,@Param("shopId") Long shopId);

    List<Car> selectCars(@Param("shopId") Long shopId,
                         @Param("model") String model,
                         @Param("brand") String brand,
                         @Param("carOnwerName") String carOnwerName);

}
