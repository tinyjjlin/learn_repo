package com.brs.oa.mapperTest;

import com.alibaba.fastjson.JSONObject;
import com.brs.oa.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void listUser(){

       List<JSONObject> list = userDao.listUser();

        for (int i=0;i<list.size();i++){

            System.out.println(list.get(i).toJSONString());
        }

    }
}
