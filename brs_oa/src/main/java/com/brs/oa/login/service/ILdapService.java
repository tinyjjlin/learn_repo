package com.brs.oa.login.service;

import com.brs.oa.login.dto.LoginDto;

/**
 * @author tiny lin
 * @date 2018/12/4
 */
public interface ILdapService {
    /**
     * 登录用户认证
     * @param loginDto
     * @return
     * @throws Exception
     */
    public Boolean authentication(LoginDto loginDto)throws Exception;

    /**
     * ldap 检验用户名密码
     * @param userDn
     * @param password
     * @return
     */
    public Boolean ldapLoginVerify(String userDn, String password);
}
