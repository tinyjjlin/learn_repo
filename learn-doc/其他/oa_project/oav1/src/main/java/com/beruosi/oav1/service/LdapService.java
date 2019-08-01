package com.beruosi.oav1.service;

import com.beruosi.oav1.entity.User;

import javax.servlet.Filter;
import java.util.List;

public interface LdapService {
    //身份认证
    public boolean authenticate(String userName, String password);

    //获取用户信息
    public List<User> getPersonList(String ldapBase, Filter filter) ;


}
