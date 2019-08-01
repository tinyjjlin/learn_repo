package com.brs.oa.mapperTest;

import com.alibaba.fastjson.JSONObject;
import com.brs.oa.dao.SalaryDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryMapperTest {

    @Autowired
    private SalaryDao salaryDao;

    @Test
    public void listUser(){

        List<JSONObject> list = salaryDao.query(100057, "col_1,col_2,col_3,user_uid");

        for (int i=0;i<list.size();i++){

            System.out.println(list.get(i).toJSONString());
        }

    }
}


