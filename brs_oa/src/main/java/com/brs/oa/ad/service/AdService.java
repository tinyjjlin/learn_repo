package com.brs.oa.ad.service;

/**
 * @author tiny lin
 * @date 2018/12/24
 */
public interface AdService {
    /**
     * 将ldap中数据同步到mysql中
     */
    public int synchronizeStaffInfo();
}
