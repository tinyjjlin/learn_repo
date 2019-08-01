package com.brs.oa.service;

import com.brs.oa.model.User;
import com.brs.oa.model.UserPermission;
import com.brs.oa.model.UserRole;

import java.util.List;


public interface LoginService {


    User findUserByUserIdAndPwd(Integer userId,String password);
    List<UserRole> findUserRole(Integer userId);
    List<UserPermission> findUserPermissionByRoleCode(String roleCode);
}
