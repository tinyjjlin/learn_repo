package com.brs.oa.staff.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author tiny lin
 * @date 2018/12/29
 */
@Data
public class StaffImportantInfoVo {

    /**
     * 工号
     */
    private Integer empNo;

    /**
     * 最高学历
     */
    private String highestDegree;


    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 婚姻状况
     */
    private Integer maritalStatus;

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

}
