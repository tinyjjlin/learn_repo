package com.brs.oa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.brs.oa.comm.annotation.ResponseFieldAuth;
import com.brs.oa.mapper.SalaryMapper;
import com.brs.oa.model.Salary;
import com.brs.oa.service.SalaryService;
import com.brs.oa.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SalaryServiceImpl2 implements SalaryService {
    static final Logger LOG = LoggerFactory.getLogger(SalaryService.class);
    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public List<Salary> findSalary(Integer userId) {
      return   salaryMapper.queryByUserId(userId);
    }

    @Override
    //@ResponseFieldAuth
    public List<JSONObject> findSalaryByUserId(Integer userId) {
        List<Salary> salaryList = salaryMapper.queryByUserId(userId);
        return   JsonUtil.JavaList2JsonList(Collections.singletonList(salaryList));
    }
}
