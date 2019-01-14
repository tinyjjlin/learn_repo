package com.brs.oa.holidayschedule.service.impl;

import com.brs.oa.holidayschedule.entity.HolidaySchedule;
import com.brs.oa.holidayschedule.mapper.HolidayScheduleMapper;
import com.brs.oa.holidayschedule.service.IHolidayScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 放假安排 服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-12
 */
@Service
public class HolidayScheduleServiceImpl  implements IHolidayScheduleService {

    @Autowired(required = false)
    private HolidayScheduleMapper holidayScheduleMapper;
    @Override
    public List<HolidaySchedule> selectListByMonth(int month) {
        return holidayScheduleMapper.selectListByMonth(month);
    }
}
