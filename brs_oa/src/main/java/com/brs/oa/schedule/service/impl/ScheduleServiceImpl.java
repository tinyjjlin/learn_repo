package com.brs.oa.schedule.service.impl;


import com.brs.oa.schedule.entity.Schedule;
import com.brs.oa.schedule.mapper.ScheduleMapper;
import com.brs.oa.schedule.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 排班（班次） 服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-09
 */
@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired(required = false)
    private ScheduleMapper scheduleMapper;
    @Override
    public int save(Schedule schedule) {
        return scheduleMapper.save(schedule);
    }

    @Override
    public int edit(Schedule schedule) {
        return scheduleMapper.update(schedule);
    }

    @Override
    public Schedule selectOne() {
        return scheduleMapper.selectOne();
    }
}
