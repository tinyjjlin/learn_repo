package com.brs.oa.holidayschedule.service;


import com.brs.oa.holidayschedule.entity.HolidaySchedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放假安排 服务类
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-12
 */
public interface IHolidayScheduleService {

    /**
     * 获取指定月份对应的放假，调休安排
     * @param month
     * @return
     */
    List<HolidaySchedule> selectListByMonth( int month);
}
