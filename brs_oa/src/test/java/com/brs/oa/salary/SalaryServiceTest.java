package com.brs.oa.salary;

import com.brs.oa.salary.mapper.SalaryMonthlyReportMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author tiny lin
 * @date 2018/12/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryServiceTest {

    @Autowired(required = false)
     private SalaryMonthlyReportMapper salaryMonthlyReportMapper;
    @Test
    public void getOwnSalary(){

    }
    @Test
    public void getList(){

    }
}
