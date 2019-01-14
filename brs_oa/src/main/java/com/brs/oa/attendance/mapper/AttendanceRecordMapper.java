package com.brs.oa.attendance.mapper;


import com.brs.oa.attendance.vo.AttendanceRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.sql.Timestamp;

import java.util.List;

/**
 * <p>
 * 考勤（打卡）记录 Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-18
 */
public interface AttendanceRecordMapper {
    /**
     * 查询指定日期员工的打卡信息。
     * @param empNo
     * @param date
     * @return
     */
    List<Timestamp> selectList(@Param("empNo") Integer empNo, @Param("selectedDate")Date date);

    /**
     * 查询指定时间范围内的员工的打卡记录
     * @param empNo
     * @param startTime
     * @param endTime
     * @return
     */
    List<AttendanceRecordVo>selectListRange(@Param("empNo")Integer empNo, @Param("startTime") Date startTime, @Param("endTime")Date endTime);


    List<Timestamp> selectList2(@Param("empNo") Integer empNo, @Param("selectedDate")String date);
}
