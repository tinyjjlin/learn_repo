package com.brs.oa.service.impl;

import com.brs.oa.mapper.FieldMapper;
import com.brs.oa.comm.fieldAuth.FieldSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FieldServiceImpl {

    @Autowired
    private  FieldMapper fieldMapper;

    public List<FieldSchema>  findFieldByUserCodeAndDToName(String userCode,String dtoName){
         return   fieldMapper.queryFieldByUserCodeAndDtoName(userCode,dtoName );
    }

    public Map<String,FieldSchema>  findFieldByUserCodeAndDToName2(String userCode,String dtoName){
        List<FieldSchema> list = findFieldByUserCodeAndDToName(userCode,dtoName );
        Map<String, FieldSchema> columnMap = new HashMap<>(list.size());

        for (FieldSchema column : list) {
            //将字段名与权限表字段对应
            System.out.println("column---field:--->"+column.getField_name());
            columnMap.put(column.getField_name(), column);

        }
        return   columnMap;
    }
}
