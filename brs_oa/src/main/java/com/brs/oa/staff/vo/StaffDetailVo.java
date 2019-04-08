package com.brs.oa.staff.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@Data
public class StaffDetailVo {

    private static final long serialVersionUID = 1L;

    private Integer empNo;

    private String name;

    private Integer deptNo;

    private String email;

    private LocalDate birthday;

    private LocalDate hireDate;

    private String nation;

    private String politicsStatus;

    private String highestDegree;

    private Integer maritalStatus;

    private String mobile;

    private String currentAddress;

    private String address;

    /**
     * 中华人民共和国身份证号
     */
    private String nationIdcard;

    private String position;

    private Integer gender;

    /**
     * 员工头像
     */
    private String picture;

    /**
     * 表创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 表修改时间
     */
    private LocalDateTime gmtModified;

}
