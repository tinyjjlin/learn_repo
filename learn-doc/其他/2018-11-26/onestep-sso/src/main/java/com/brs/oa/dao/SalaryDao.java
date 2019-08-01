package com.brs.oa.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryDao {

    List<JSONObject> query(@Param("userId")Integer userId,@Param("fields")String fields);
}
