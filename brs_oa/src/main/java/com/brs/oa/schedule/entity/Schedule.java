package com.brs.oa.schedule.entity;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 排班（班次）
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班次名称
     */
    private String name;

    /**
     * 是否启用，1代表启用；0代表禁止。
     */
    private Integer isEnabled;

    /**
     * 上班时间
     */
    private String workingHours;

    /**
     * 最早上班时间
     */
    private String earliestWorkingHours;

    /**
     * 最迟上班时间
     */
    private String lastestWorkingHours;

    /**
     * 下班时间 
     */
    private String offHours;

    /**
     * 下班最早有效时间
     */
    private String earliestOffHours;

    /**
     * 最晚下班时间
     */
    private String lastestOffHours;

    /**
     * 每月允许迟到时间范围
     */
    private Integer permitLateTime;

    /**
     * 每月允许指定时间范围内迟到的机会
     */
    private Integer permitLateOccasion;

    /**
     * 每月允许忘记打卡机会
     */
    private Integer permitForgetClock;

    /**
     * 上班迟到的时间范围，超过算旷工
     */
    private Integer permitOnLimit;

    /**
     * 下班早退时间范围，早于该时间范围算旷工
     */
    private Integer permitOffLimit;

    /**
     * 员工号（设置考勤参数的人）
     */
    private Integer staffEmpNo;


}
