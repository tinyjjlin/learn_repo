package com.brs.oa.clockrecord.service;

import com.brs.oa.clockrecord.entity.ClockRecord;
import com.brs.oa.clockrecord.vo.ClockRecordVo;

import java.util.Date;
import java.util.List;

/**
 * @author tiny lin
 * @date 2019/1/11
 */
public interface IClockRecordService {

    /**
     * 保存打卡记录
     * @param clockRecord
     * @return
     */
    int save(ClockRecord clockRecord);


    /**
     * 查看打卡记录
     * @param empNo
     * @param selectedDate
     * @return
     */
    List<ClockRecordVo> selectClockRecordList(Integer empNo, String selectedDate);

    /**
     * 查看员工月打卡记录
     * @param empNo
     * @param selectedMonth
     * @return
     */
    List<ClockRecordVo> selectClockRecordListByMonth(Integer empNo, String selectedMonth);

    /**
     * 查看员工指定时间范围打卡记录
     * @param empNo
     * @param startTime
     * @param endTime
     * @return
     */
    List<ClockRecordVo> selectClockRecordListRange(Integer empNo, Date startTime, Date endTime);
}
