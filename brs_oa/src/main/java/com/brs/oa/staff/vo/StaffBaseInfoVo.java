package com.brs.oa.staff.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author tiny lin
 * @date 2018/12/29
 */
@Data
public class StaffBaseInfoVo {

    /**
     * 员工头像
     */
    private String picture;


    /**
     * 员工姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 民族
     */
    private String nation;

    /**
     * 政治面貌
     */
    private String politicsStatus;



    /**
     * 工号
     */
    private Integer empNo;
    /**
     * 职位
     */
    private String position;

    /**
     * 部门号
     */
    private Integer deptNo;

    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 入职日期
     */
    private LocalDate hireDate;


    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;


    /**
     * 个人爱好
     */
    private String hobby;



}
