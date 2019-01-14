package com.brs.oa.attendance.service;


import com.brs.oa.attendance.vo.AttendanceRecordVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 考勤（打卡）记录 服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-18
 */
public interface IAttendanceRecordService{



    /**
     * 查看员工考勤月历
     * @param empNo
     * @param selectedMonth 2019-1
     * @return
     */
    List<AttendanceRecordVo> getRecordListByMonth(Integer empNo,String selectedMonth);
}
