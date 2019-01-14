package com.brs.oa.clockrecord.mapper;

import com.brs.oa.clockrecord.entity.ClockRecord;
import com.brs.oa.clockrecord.vo.ClockRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author tiny lin
 * @date 2019/1/9
 */
public interface ClockRecordVoMapper {

    int insert(@Param("clockRecord") ClockRecord clockRecord);
    /**
     * 获取员工的打卡记录
     * @param empNo
     * @param startTime
     * @param endTime
     * @return
     */
    List<ClockRecordVo> selectRecordListRange(@Param("empNo")Integer empNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 查看员工指定日期打卡记录
     * @param empNo
     * @param selectedDate
     * @return
     */
    ClockRecordVo selectRecordByDay(@Param("empNo")Integer empNo,@Param("selectedDate") String selectedDate);

    /**
     * 查看员工的打卡记录列表
     * @param empNo
     * @param selectedDate
     * @return
     */
    List<ClockRecordVo> selectRecordList(@Param("empNo")Integer empNo,@Param("selectedDate") String selectedDate);



    /**
     * 查看员工月打卡记录
     * @param empNo
     * @param selectedMonth
     * @return
     */
    List<ClockRecordVo> selectRecordListByMonth(@Param("empNo")Integer empNo, @Param("selectedMonth") String selectedMonth);
}
