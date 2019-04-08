package com.brs.oa.holidayschedule.entity;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 放假安排
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HolidaySchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 放假日期,调休上班日期
     */
    private String hDay;

    /**
     * 日期对应的类型：0代表工作日，1代表休息日，2代表节假日
     */
    private Integer hType;

    /**
     * 节日
     */
    private String hFestival;


}
