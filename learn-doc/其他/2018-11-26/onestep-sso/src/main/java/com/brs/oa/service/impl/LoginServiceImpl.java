package com.brs.oa.service.impl;


import com.brs.oa.exception.CustomException;
import com.brs.oa.model.*;
import com.brs.oa.service.LoginService;
import com.brs.oa.mapper.LoginUserMapper;
import com.brs.oa.util.StrUtil;
import org.apache.shiro.crypto.hash.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginUserMapper loginUserMapper;


    //登录用户认证
    public LoginUser authentication(String userCode, String password) throws Exception {
        //step 1: 请求字段不为空
        if (StrUtil.isNUll(userCode) || StrUtil.isNUll(password)) {
            throw new CustomException("用户名或密码为空！");
        }

        User user = findUserByUserCode(userCode);
        //step 2:
        if(user == null){
            throw new CustomException("用户不存在！");
        }

        String pwdMD5 = user.getPwd();
        String enterPwdMD5 =password;
        // TODO
        //密码加密
        if(!enterPwdMD5.equalsIgnoreCase(pwdMD5)){
            throw new CustomException("用户名或密码错误！");
        }
        LoginUser loginUser = new LoginUser();

        loginUser.getUid(user.getUid());
        loginUser.setPwd(user.getPwd());
        loginUser.setName(user.getName());
        loginUser.setCode(user.getCode());
        loginUser.setPermissions(findUserPermissionByUserCode(userCode));

       return loginUser;
    }

    //根据登录账号查询用户信息
    public User findUserByUserCode(String userCode) {
        return loginUserMapper.queryUserByUserCode(userCode);
    }
    //根据登录账号查询权限信息
    public List<Permission>findUserPermissionByUserCode(String userCode){
        return loginUserMapper.queryPermissionByUserCode(userCode);
    }

















    @Override
    public User findUserByUserIdAndPwd(Integer userId, String password) {
        return loginUserMapper.queryUserByUserIdAndPwd(userId, password);
    }

    @Override
    public List <UserRole> findUserRole(Integer userId) {
        return loginUserMapper.queryUserRoleByUserId(userId);
    }

    @Override
    public List <UserPermission> findUserPermissionByRoleCode(String roleCode) {
        return loginUserMapper.queryActionPermissonByRoleCode(roleCode);
    }
}

