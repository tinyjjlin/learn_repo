package com.brs.oa.attendance.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author tiny lin
 * @date 2018/12/18
 */
@Data
public class AttendanceRecordVo {


    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 签到时间
     */
    private Date clockInTime;

    /**
     * 签退时间
     */
    private Date clockOutTime;

    /**
     * 上班状态，迟到，旷工
     */
    private String onStatus;

    /**
     * 下班状态，早退，旷工
     */
    private String offStatus;

    /**
     * 日期类型：0代表工作日，1代表休息日，2代表节假日
     */
    private int dayType;


}
