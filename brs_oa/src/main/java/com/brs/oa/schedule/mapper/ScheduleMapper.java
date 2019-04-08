package com.brs.oa.schedule.mapper;


import com.brs.oa.schedule.entity.Schedule;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 排班（班次） Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-09
 */
public interface ScheduleMapper {

    /**
     * 设置考勤参数
     * @param schedule
     * @return
     */
    int save(@Param("schedule")Schedule schedule);

    int update(@Param("schedule")Schedule schedule);

    /**
     * 查看考勤参数
     * @return
     */
    Schedule selectOne();

}
