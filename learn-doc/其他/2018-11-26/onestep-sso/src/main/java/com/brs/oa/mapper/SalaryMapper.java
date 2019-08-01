package com.brs.oa.mapper;

import com.brs.oa.model.Salary;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SalaryMapper {
    @Select(" select user_uid,col_1,col_2,col_3,col_4 from brs_salary")
    List<Salary> queryByUserId(Integer userId);

}
