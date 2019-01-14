package com.brs.oa.clockrecord.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author tiny lin
 * @date 2018/12/20
 */
@Data
public class ClockRecordVo {

    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 员工姓名
     */
    private String epmName;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 打卡日期
     */
    private Date clockDay;

    /**
     * 签到时间
     */
    private Date  clockInTime;

    /**
     * 签退时间
     */
    private Date clockOutTime;

    /**
     * 打卡时间记录
     */
    private String clockTimes;
}
