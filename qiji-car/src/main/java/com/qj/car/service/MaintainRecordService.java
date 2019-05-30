package com.qj.car.service;

import com.qj.car.domain.MaintainRecord;

import java.util.Date;
import java.util.List;

/****
 * author:lqm
 * 2019-05-30
 **/
public interface MaintainRecordService {


    void addMaintainRecord(MaintainRecord maintainRecord);

    void update(MaintainRecord maintainRecord);

    List<MaintainRecord> getByCarId(Long carId,Long shopId);

    MaintainRecord getById(Long id,Long shopId);

    List<MaintainRecord> getListByCarId(Date from, Date end, String brand, Long shopId);

}
