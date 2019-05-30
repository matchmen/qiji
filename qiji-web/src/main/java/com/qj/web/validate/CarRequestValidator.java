package com.qj.web.validate;

import com.qj.car.domain.Car;
import com.qj.car.service.CarService;
import com.qj.common.embed.ReturnResult;
import com.qj.web.request.car.AddCarRequest;
import com.qj.web.response.car.UpdateCarInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/****
 * author:lqm
 * 2019-05-29
 **/
@Component
public class CarRequestValidator extends BaseValidator{

    @Autowired
    private CarService carService;

    public ReturnResult<String> addCarValidate(AddCarRequest request) {

        Car car = carService.getCarByModel(request.getModel(), request.getShopId());
        if(Objects.isNull(car)){
            return assembleResult(false,"汽车型号已经存在");
        }

        return ok;

    }

    public ReturnResult<String> updateCarInfoValidate(UpdateCarInfoRequest request) {

        Car car = carService.getCarById(request.getId(), request.getShopId());

        if (Objects.isNull(car)) {
            return assembleResult(false, "ID不存在");
        }

        return ok;
    }


}
