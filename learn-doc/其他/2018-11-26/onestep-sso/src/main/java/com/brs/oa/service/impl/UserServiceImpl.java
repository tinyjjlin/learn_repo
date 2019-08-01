package com.brs.oa.service.impl;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.brs.oa.comm.fieldAuth.FilterableResult;
import com.brs.oa.comm.fieldAuth.QueryFilter;
import com.brs.oa.mapper.UserMapper;
import com.brs.oa.model.User;
import com.brs.oa.model.dto.UserDTO;
import com.brs.oa.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserSerivce {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserIdAndPwd(String userId, String pwd) {
        return null;
    }

    @QueryFilter(dtoName = "UserDTO")
    public JSONArray findUser3(){
        List<User> userList =  userMapper.queryUser();
       List<UserDTO> userDTOS = covertTODTO(userList);
       return (JSONArray) JSON.toJSON(userDTOS);
    }

    @QueryFilter(dtoName = "UserDTO")
    public FilterableResult<UserDTO> findUser(){
        List<User> userList =  userMapper.queryUser();
        return  FilterableResult.build(covertTODTO(userList));

    }



    public List<UserDTO> findUser2(){
        FilterableResult<UserDTO> filterableResult = findUser();
        List<UserDTO> userDTOList = filterableResult.getRows();
      return userDTOList;
    }

    public List<UserDTO> covertTODTO(List<User>userList){
        List<UserDTO> userDtoList = new ArrayList <>();

        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            UserDTO userDTO = new UserDTO();
            userDTO.setCode(user.getCode());
            userDTO.setName(user.getName());
            userDTO.setUid(user.getUid());
            userDTO.setPwd(user.getPwd());

            System.out.println("user info =================>"+user.getName());

            userDtoList.add(userDTO);
        }
        return userDtoList;
    }
}


