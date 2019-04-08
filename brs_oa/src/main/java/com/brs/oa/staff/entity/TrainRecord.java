package com.brs.oa.staff.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 培训记录
 * @author tiny lin
 * @date 2018/12/28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TrainRecord implements Serializable {

    private Integer trainRecordId;
    /**
     * 员工工号
     */

    private Integer staffEmpNo;

    /**
     * 起止时间
     */
    private String trainStartEndTime;

    /**
     * 培训机构
     */
    private String trainAgency;

    /**
     * 培训课程
     */
    private String trainCourse;
}
