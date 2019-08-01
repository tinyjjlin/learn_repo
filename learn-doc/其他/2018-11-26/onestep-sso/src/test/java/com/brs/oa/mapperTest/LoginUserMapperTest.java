package com.brs.oa.mapperTest;

import com.brs.oa.model.User;
import com.brs.oa.mapper.LoginUserMapper;
import com.brs.oa.model.UserPermission;
import com.brs.oa.model.UserRole;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginUserMapperTest {
    static final Logger LOG = LoggerFactory.getLogger(LoginUserMapperTest.class);

    @Autowired
    private LoginUserMapper loginUserMapper;


    @Test
    public void queryUser(){
        //test user
       // User user = new User();
       // user.setUid("100057");
       // user.setPwd("linlin00");
        Integer userId = 100057;
        String pwd = "linlin00";
        User user1 =loginUserMapper.queryUserByUserIdAndPwd(userId,pwd );
        if(user1 != null){
            LOG.info("queryUser test------>"+user1.toString());
        }


    }

    @Ignore
    @Test
    public void queryRole(){
        Integer userId = 100057;
        List<UserRole> roles =loginUserMapper.queryUserRoleByUserId(userId);
        for (int i=0;i<roles.size();i++){
            LOG.info("roles--->"+roles.get(i).getCode()+",role name:"+roles.get(i).getName());
        }

    }

    @Test
    public void queryPermission(){
        List<UserPermission> permissions = loginUserMapper.queryActionPermissonByRoleCode("01");
        for (int i=0;i<permissions.size();i++){
            LOG.info("roles--->"+permissions.get(i).getCode()+",role name:"+permissions.get(i).getName());
        }

    }

}
