package com.qj.car.service.impl;

import com.qj.car.domain.MaintainRecord;
import com.qj.car.mapper.MaintainRecordMapper;
import com.qj.car.service.MaintainRecordService;
import com.qj.common.utils.IdGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/****
 *
 * author:lqm
 * 2019-05-30
 **/
@Service
public class MaintainRecordServiceImpl implements MaintainRecordService {

    private MaintainRecordMapper maintainRecordMapper;

    @Override
    @Transactional
    public void addMaintainRecord(MaintainRecord maintainRecord) {

        maintainRecord.setId(IdGenerator.generateId());

        maintainRecordMapper.insertMaintainRecord(maintainRecord);

    }

    @Override
    @Transactional
    public void update(MaintainRecord maintainRecord) {

        maintainRecordMapper.updateMaintain(maintainRecord);

    }

    @Override
    public List<MaintainRecord> getByCarId(Long carId, Long shopId) {
        return maintainRecordMapper.selectByCarId(carId, shopId);
    }

    @Override
    public MaintainRecord getById(Long id, Long shopId) {
        return maintainRecordMapper.selectById(id, shopId);
    }

    @Override
    public List<MaintainRecord> getListByCarId(Date from, Date end, String brand, Long shopId) {

        return maintainRecordMapper.selectList(from, end, brand, shopId);
    }
}
