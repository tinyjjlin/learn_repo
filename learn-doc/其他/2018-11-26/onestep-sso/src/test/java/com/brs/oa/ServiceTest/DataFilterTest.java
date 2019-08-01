//package com.brs.oa.ServiceTest;
//
//import com.alibaba.fastjson.JSONObject;
//import com.brs.oa.datafilter.FilterableResult;
//import com.brs.oa.datafilter.SysUserServiceImpl;
//import com.brs.oa.model.Salary;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DataFilterTest {
//
//    @Autowired
//    private SysUserServiceImpl sysUserService;
//    @Test
//    public void test(){
//        FilterableResult<Salary> salary=sysUserService.findSalary();
//        System.out.println("new salary----->"+ JSONObject.toJSON(salary).toString());
//    }
//}
