package com.brs.oa.staff.vo;

import lombok.Data;

import javax.print.event.PrintJobAttributeEvent;
import java.time.LocalDate;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@Data
public class SimpleStaffVo {
    /**
     * department table :dept_name
     */
    private String deptName;
    private Integer empNo;
    private String name;
    private String email;
    private String mobile;
    private String position;
    private Integer gender;
    private String picture;

}
