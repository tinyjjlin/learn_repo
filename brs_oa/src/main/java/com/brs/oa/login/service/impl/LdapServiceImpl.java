package com.brs.oa.login.service.impl;


import com.brs.oa.login.dto.LoginDto;
import com.brs.oa.comm.exception.CustomException;
import com.brs.oa.login.service.ILdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.naming.directory.DirContext;

/**
 * @author tiny lin
 * @date 2018/12/4
 */
@Service
public class LdapServiceImpl implements ILdapService {

    @Value("${ldap.domainName}")
    private String ldapDomainName;


    @Autowired
    private LdapTemplate ldapTemplate;


    @Override
    public Boolean authentication(LoginDto loginDto) throws Exception {
        String userDn = loginDto.getUsername() + ldapDomainName;
        //step 1: 请求字段不为空
        if (StringUtils.isEmpty(loginDto.getUsername()) || StringUtils.isEmpty(loginDto.getPassword())) {
            throw new CustomException("用户名或密码为空！");
        }
        //setp 2: ldap 验证
        if( !ldapLoginVerify(userDn, loginDto.getPassword())){
            throw new CustomException("用户名或密码错误！");
        }
        return true;
    }



    @Override
    public Boolean ldapLoginVerify(String userDn, String password) {
        System.out.println("ldapLoginVerify -->userDn:.........."+userDn);
        System.out.println("ldapLoginVerify -->password:.........."+password);
        DirContext dirContext = null;
        try {
            dirContext = ldapTemplate.getContextSource().getContext(userDn, password);
            return true;
        } catch (Exception e) {
           // e.printStackTrace();
            return false;
        } finally {
            LdapUtils.closeContext(dirContext);
        }

    }
}
