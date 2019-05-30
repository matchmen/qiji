package com.qj.web.controller;

import com.qj.car.domain.Car;
import com.qj.car.service.CarService;
import com.qj.common.embed.ReturnResult;
import com.qj.security.utils.SessionUtils;
import com.qj.security.vo.ResultVO;
import com.qj.web.request.car.AddCarRequest;
import com.qj.web.request.car.GetCarsRequest;
import com.qj.web.response.car.GetCarsReponse;
import com.qj.web.response.car.UpdateCarInfoRequest;
import com.qj.web.validate.CarRequestValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/****
 * author:lqm
 * 2019-05-29
 **/
@Controller
@RequestMapping("/qj/car")
public class CarController extends BaseController{


    @Autowired
    private CarService carService;

    @Autowired
    private CarRequestValidator carRequestValidator;

    @PostMapping("/addCar")
    @ResponseBody
    public ResultVO addCar(@RequestBody AddCarRequest request) {

        request.setShopId(SessionUtils.getShopId());

        ReturnResult result = carRequestValidator.addCarValidate(request);

        if(!result.getIsSuccess()){
            return assembleResult(result);
        }

        Car car = new Car();

        BeanUtils.copyProperties(request, car);

        carService.addCar(car);

        return success;
    }

    @PostMapping("/isExistModel")
    @ResponseBody
    public ResultVO<String> isExistModel(@RequestParam("model") String model) {

        Car car = carService.getCarByModel(model, getShopId());

        if(!Objects.isNull(car)){
            return assembleResult(true, "成功", "TRUE");
        }else {
            return assembleResult(true, "成功", "FALSE");
        }

    }

    @PostMapping("/getCars")
    @ResponseBody
    public ResultVO<List<GetCarsReponse>> getCars(@RequestBody GetCarsRequest request) {

        List<Car> carList = carService.getCarList(getShopId(),request.getModel(), request.getBrand(), request.getCarOnwerName());

        List<GetCarsReponse> reponses = new ArrayList<>();
        for (Car car:carList) {
            GetCarsReponse reponse = new GetCarsReponse();
            BeanUtils.copyProperties(car, reponse);
            reponses.add(reponse);
        }
        return assembleResult(true, "成功", reponses);

    }

    @PostMapping("/getCarInfo")
    @ResponseBody
    public ResultVO<Car> getCarInfo(Long id) {

        Car car = carService.getCarById(id, getShopId());

        return assembleResult(true, "成功", car);

    }

    @ResponseBody
    @PostMapping("/updateCarInfo")
    public ResultVO<String> updateCarInfo(@RequestBody UpdateCarInfoRequest request) {

        ReturnResult result = carRequestValidator.updateCarInfoValidate(request);

        if(!result.getIsSuccess()){
            return assembleResult(result);
        }

        Car car = new Car();

        BeanUtils.copyProperties(request, car);

        carService.updateCar(car);

        return success;
    }

}
