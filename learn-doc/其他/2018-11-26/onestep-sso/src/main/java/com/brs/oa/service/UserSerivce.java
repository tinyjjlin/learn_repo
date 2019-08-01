package com.brs.oa.service;

import com.brs.oa.model.User;

public interface UserSerivce {
    User findUserByUserIdAndPwd(String userId, String pwd);

}
