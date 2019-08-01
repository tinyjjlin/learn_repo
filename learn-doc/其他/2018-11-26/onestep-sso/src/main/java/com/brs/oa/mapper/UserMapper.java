package com.brs.oa.mapper;

import com.brs.oa.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select uid,code,name,pwd from brs_user ")
    public List<User> queryUser();
}
