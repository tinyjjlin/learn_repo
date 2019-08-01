package com.brs.oa.model.entityModel;

import com.alibaba.fastjson.JSONObject;
import com.brs.oa.model.viewModel.VSalary;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

public class ViewDataFactory {
    //1 规则器
    // getRole()
    String fieldRule="a,b,c,d"; //表中的字段， 与实体一一对应。
    // 2 对应的实体模型
    //根据规则器，生成新的实体数据模型

    public VSalary genereate(){

        return  new VSalary();
    }

    private Object entityObject;
    private JSONObject fieldRuleJson;

    public Object generate(Object entityObject){

        return new Object();
    }

}
