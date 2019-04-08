package com.brs.oa.staff.vo;

import com.brs.oa.staff.entity.EducationRecord;
import com.brs.oa.staff.entity.TrainRecord;
import com.brs.oa.staff.entity.WorkRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StaffDetailInfo implements Serializable {

    /**
     * 个人基本信息=====================================
     */

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

    /**
     * 婚姻状况
     */
    private Integer maritalStatus;



    /**
     * 最高学历
     */
    private String highestDegree;


    /**
     * 出生日期
     */
    private LocalDate birthday;



    /**
     * 现居住地址
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
     * 社保账号
     */
    private String socialInsuranceAccount;


    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系人电话
     */
    private String emergencyContactPhone;

    /**
     * 教育记录
     */
    private List<EducationRecord> educationRecordList;
    /**
     * 工作经历
     */
    private List<WorkRecord> workExperienceList;

    /**
     * 培训记录
     */
   private List<TrainRecord> trainRecordList;

}
