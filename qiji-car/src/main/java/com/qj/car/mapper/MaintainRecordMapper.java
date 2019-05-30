package com.qj.car.mapper;

import com.qj.car.domain.MaintainRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/****
 * author:lqm
 * 2019-05-30
 **/
public interface MaintainRecordMapper {

    void insertMaintainRecord(MaintainRecord maintainRecord);

    void updateMaintain(MaintainRecord maintainRecord);

    MaintainRecord selectById(@Param("id") Long id, @Param("shopId") Long shopId);

    List<MaintainRecord> selectByCarId(@Param("carId") Long carId, @Param("shopId") Long shopId);

    List<MaintainRecord> selectList(@Param("from") Date from,
                                    @Param("end") Date end,
                                    @Param("brand") String brand,
                                    @Param("shopId") Long shopId);

}
