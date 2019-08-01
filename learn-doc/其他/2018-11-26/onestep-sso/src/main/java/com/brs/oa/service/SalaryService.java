package com.brs.oa.service;

import com.alibaba.fastjson.JSONObject;
import com.brs.oa.model.Salary;

import java.util.List;

public interface SalaryService {
    List <Salary> findSalary(Integer userId);

    List <JSONObject> findSalaryByUserId(Integer userId);


}
