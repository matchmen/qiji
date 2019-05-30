package com.qj.web.controller;

import com.qj.car.domain.MaintainRecord;
import com.qj.car.service.MaintainRecordService;
import com.qj.security.vo.ResultVO;
import com.qj.web.request.car.AddMaintainRecordRequest;
import com.qj.web.request.car.UpdateMaintainRecordRequest;
import com.qj.web.response.car.GetMaintainRecordResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/****
 * author:lqm
 * 2019-05-29
 **/
@Controller
@RequestMapping("/qj/maintainRecord")
public class MaintainRecordController extends BaseController{

    @Autowired
    private MaintainRecordService maintainRecordService;

    @ResponseBody
    @RequestMapping("/addMaintainRecord")
    public ResultVO<String> addMaintainRecord(AddMaintainRecordRequest recordRequest) {

        recordRequest.setShopId(getShopId());
        recordRequest.setPersionInchangeId(getUserId());
        MaintainRecord record = new MaintainRecord();
        BeanUtils.copyProperties(recordRequest, record);
        maintainRecordService.addMaintainRecord(record);
        return success;
    }

    @ResponseBody
    @RequestMapping("/updateMaintainRecord")
    public ResultVO<String> updateMaintainRecord(UpdateMaintainRecordRequest recordRequest) {

        recordRequest.setShopId(getShopId());
        MaintainRecord record = new MaintainRecord();
        BeanUtils.copyProperties(recordRequest, record);
        maintainRecordService.update(record);
        return success;
    }

    @ResponseBody
    @RequestMapping("/getMaintainRecord")
    public ResultVO<GetMaintainRecordResponse> getMaintainRecord(@RequestParam Long carId) {

        List<MaintainRecord> record = maintainRecordService.getByCarId(carId, getShopId());

        GetMaintainRecordResponse recordResponse = new GetMaintainRecordResponse();

        BeanUtils.copyProperties(record, recordResponse);

        return assembleResult(true, "成功", recordResponse);

    }

    @ResponseBody
    @RequestMapping("/getMaintainRecords")
    public ResultVO<GetMaintainRecordResponse> getMaintainRecords(@RequestParam Long carId) {

        List<MaintainRecord> records = maintainRecordService.getByCarId(carId, getShopId());

        List<GetMaintainRecordResponse> recordResponses = new ArrayList<>();

        for (MaintainRecord record:records) {
            GetMaintainRecordResponse recordResponse = new GetMaintainRecordResponse();
            BeanUtils.copyProperties(record, recordResponse);
            recordResponses.add(recordResponse);
        }

        return assembleResult(true, "成功", recordResponses);
    }

}
