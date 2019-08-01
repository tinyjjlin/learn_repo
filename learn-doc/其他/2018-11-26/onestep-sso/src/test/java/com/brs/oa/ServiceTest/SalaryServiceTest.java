package com.brs.oa.ServiceTest;

import com.brs.oa.service.SalaryService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryServiceTest {

    @Autowired
    private SalaryService salaryService;
   @Test
    public void test(){

       salaryService.findSalary(100057);


    }
}
