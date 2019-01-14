package com.brs.oa.ad.entry;

import lombok.Data;

import javax.naming.Name;

/**
 * @author tiny lin
 * @date 2018/12/24
 */
@Data
public class Person {

    private Name dn;
    private String referralUrl;
    /**
     * distinguishedName
     */
    private String distinguishedName;
    /**
     * cn
     */
    private String fullName;
    /**
     * sAMAccountName
     */
    private String accountName;

    /**
     * 员工号
     */
    private Integer empNo;
}