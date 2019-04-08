package com.brs.oa.attendance.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author tiny lin
 * @date 2018/12/18
 */
@Data
public class AttendanceStatisticsVo {
    /**
      * 员工姓名
     */
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              private String name;

    /**
     * 应该工作天数
     */
    private BigDecimal workDay;

    /**
     * 实际工作天数
     */
    private BigDecimal realWorkDay;

    /**
     * 迟到总次数
     */
    private Integer lateCount;

    /**
     * 严重迟到
     */
    private Integer seriousLateCount;

    /**
     * 早退次数
     */
    private Integer leaveEarlyCount;

    /**
     * 严重早退次数
     */
    private Integer seriousLeaveEarlyCount;


    /**
     * 旷工天数
     */
    private BigDecimal absentDay;

    /**
     * 忘记刷卡次数
     */
    private Integer forgetBrushCardCount;


    /**
     * 年假
     */
    private BigDecimal annualLeaveDay;

    /**
     * 事假
     */
    private BigDecimal personalLeaveDay;
    /**
     * 病假
     */
    private BigDecimal sickLeaveDay;

    /**
     * 婚假
     */
    private BigDecimal marriageLeaveDay;

    /**
     * 产假
     */
    private BigDecimal maternityLeaveDay;

    /**
     * 丧假
     */
    private BigDecimal funeralLeaveDay;

    /**
     * 陪产假
     */
    private BigDecimal paternityLeaveDay;

    /**
     * 例假
     */
    private BigDecimal casualLeaveDay;


}
