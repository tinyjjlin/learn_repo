package com.brs.oa.login.dto;

import lombok.Data;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/12
 */
@Data
public class UserInfoDto {
    /**
     * 员工工号
     */
    private Integer empNo;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工头像
     */
    private String avatar;

    /**
     * 角色列表
     */
    private List<String> roles;

    /**
     * 用户介绍
     */
    private String introduction;
}
