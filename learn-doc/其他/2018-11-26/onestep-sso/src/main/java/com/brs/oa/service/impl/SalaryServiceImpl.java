//package com.brs.oa.service.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.brs.oa.dao.SalaryDao;
//import com.brs.oa.model.Salary;
//import com.brs.oa.service.SalaryService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
////@Service
//public class SalaryServiceImpl implements SalaryService {
//    static final Logger LOG = LoggerFactory.getLogger(SalaryServiceImpl.class);
//
//    @Autowired
//    private SalaryDao salaryDao;
//
//
//
//    @Override
//    public List<JSONObject> findSalaryByUserId(Integer userId) {
//        return findSalaryByUserId(userId, "col_1,col_2,col_3");
//    }
//    public List<JSONObject> findSalaryByUserId(Integer userId,String fields) {
//        LOG.info("find salary function----------called------------->args:"+userId+",2:"+fields);
//        return salaryDao.query(userId, fields);
//    }
//
//
//
//
//    @Override
//    public List<Salary> findSalary(Integer userId) {
//        return findSalary(userId,"");
//    }
//    public List<Salary> findSalary(Integer userId,String fields) {
//        LOG.info("find salary function----------called------------->args:"+userId+",2:"+fields);
//        return null;
//    }
//}
