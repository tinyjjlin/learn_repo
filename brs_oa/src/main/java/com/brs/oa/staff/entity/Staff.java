package com.brs.oa.staff.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 贝偌偲员工表
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer staffId;
    /**
     * 工号
     */
    private Integer empNo;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 部门号
     */
    private Integer deptNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 入职日期
     */
    private LocalDate hireDate;

    /**
     * 民族
     */
    private String nation;

    /**
     * 政治面貌
     */
    private String politicsStatus;

    /**
     * 最高学历
     */
    private String highestDegree;

    /**
     * 婚姻状况
     */
    private Integer maritalStatus;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 先居住地址
     */
    private String currentAddress;

    /**
     * 地址
     */
    private String address;

    /**
     * 中华人民共和国身份证号
     */
    private String nationIdcard;

    /**
     * 职位
     */
    private String position;

    /**
     * 性别
     */
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
