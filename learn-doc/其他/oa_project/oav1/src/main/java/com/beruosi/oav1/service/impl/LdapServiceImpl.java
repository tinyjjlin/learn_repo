package com.beruosi.oav1.service.impl;

import com.beruosi.oav1.entity.User;
import com.beruosi.oav1.service.LdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;

import javax.naming.directory.DirContext;
import javax.servlet.Filter;
import java.util.List;

//@Service
public class LdapServiceImpl implements LdapService {
    @Autowired
    private LdapTemplate ldapTemplate;

    @Value("${ldap.domainName}")
    private String ldapDomainName;

    @Value("${ldap.base}")
    private String ldapBaseDn;

    @Override
    public boolean authenticate(String userName, String password) {
        String userDomainName = String.format(ldapDomainName,userName);
        DirContext ctx = null;
        try {
            ctx = ldapTemplate.getContextSource().getContext(userDomainName, password);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
        }


        return false;
    }

    @Override
    public List<User> getPersonList(String ldapBase, Filter filter) {
        return null;
    }
}
