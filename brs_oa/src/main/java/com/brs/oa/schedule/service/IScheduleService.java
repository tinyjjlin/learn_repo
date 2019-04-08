package com.brs.oa.schedule.service;

import com.brs.oa.schedule.entity.Schedule;


/**
 * <p>
 * 排班（班次） 服务类
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-09
 */
public interface IScheduleService  {
    /**
     * 保存考勤参数设置
     * @param schedule
     */
     int save(Schedule schedule);
     int edit(Schedule schedule);

    /**
     * 查看考勤参数
     * @return
     */
    Schedule selectOne();



}
