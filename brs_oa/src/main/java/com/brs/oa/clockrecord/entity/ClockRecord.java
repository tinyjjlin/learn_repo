package com.brs.oa.clockrecord.entity;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 打卡记录
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClockRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 打卡日期
     */
    private String clockDay;

    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 打卡时间
     */
    private Date clockTime;

    /**
     * 打卡方式编号
     */
    private Integer clockTypeCode;
    /**
     * 打卡方式
     */
    private String clockType;

    /**
     * 定点位置
     */
    private String position;


}
