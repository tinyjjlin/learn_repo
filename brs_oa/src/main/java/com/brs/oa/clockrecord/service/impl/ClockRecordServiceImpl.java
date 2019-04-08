package com.brs.oa.clockrecord.service.impl;

import com.brs.oa.clockrecord.entity.ClockRecord;
import com.brs.oa.clockrecord.mapper.ClockRecordVoMapper;
import com.brs.oa.clockrecord.service.IClockRecordService;
import com.brs.oa.clockrecord.vo.ClockRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author tiny lin
 * @date 2019/1/11
 */
@Service
public class ClockRecordServiceImpl implements IClockRecordService {

    @Autowired(required = false)
    private ClockRecordVoMapper clockRecordVoMapper;

    @Override
    public int save(ClockRecord clockRecord) {
        return clockRecordVoMapper.insert(clockRecord);
    }

    @Override
    public List <ClockRecordVo> selectClockRecordList(Integer empNo, String selectedDate) {
        return clockRecordVoMapper.selectRecordList(empNo,selectedDate );
    }

    @Override
    public List <ClockRecordVo> selectClockRecordListRange(Integer empNo, Date startTime, Date endTime) {
        return clockRecordVoMapper.selectRecordListRange(empNo, startTime, endTime);
    }

    @Override
    public List<ClockRecordVo> selectClockRecordListByMonth(Integer empNo, String selectedMonth) {
        return clockRecordVoMapper.selectRecordListByMonth(empNo, selectedMonth);
    }

}
