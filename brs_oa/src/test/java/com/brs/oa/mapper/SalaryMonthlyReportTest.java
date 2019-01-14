package com.brs.oa.mapper;



import com.brs.oa.salary.mapper.SalaryMonthlyReportMapper;
import com.brs.oa.salary.vo.SimpleSalaryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryMonthlyReportTest {

    @Autowired(required = false)
    private SalaryMonthlyReportMapper salaryMonthlyMapper;
    @Test
    public void test(){
        List<SimpleSalaryVo> list = salaryMonthlyMapper.queryPersonalSalaryList(100057,null,null);
        for (SimpleSalaryVo salaryMonthly : list) {
            System.out.println(salaryMonthly.getSettlementDay());
        }
    }
}
