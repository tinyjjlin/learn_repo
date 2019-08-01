package com.brs.oa.comm.apect;


import com.alibaba.fastjson.JSONObject;
import com.brs.oa.util.CommonUtil;
import com.brs.oa.util.JsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


//@Aspect
//@Configuration
public class FieldAuthAspect {
    static final Logger LOG = LoggerFactory.getLogger(FieldAuthAspect.class);

    @Pointcut("@annotation(com.brs.oa.comm.annotation.ResponseFieldAuth)")
    public void annotationPointCut(){}


    @Around("annotationPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOG.info("@Around：.......................before.......");

        // 方法执行,返回实体对象
        Object obj= proceedingJoinPoint.proceed();
        LOG.info("@Around：.......................after.......");

        // 查询数据库，获取字段规则信息
        String  fieldRule ="user_uid,col_1,col_2,col_3";
        if(obj instanceof  List){
           obj = resetListByRule(obj,fieldRule);
        }

        return obj;
    }


    public Object resetListByRule(Object obj, String fieldRule){
        List<JSONObject> returnList =(List<JSONObject>) obj;
        List<JSONObject> responseJsonList = new ArrayList <>();

        for(int i=0;i<returnList.size();i++){
            JSONObject newJsonObject =JsonUtil.responseJsonMatch(returnList.get(i),fieldRule );
            LOG.info("new json object =======================>"+newJsonObject.toJSONString());
            responseJsonList.add(newJsonObject);
        }
        returnList= null;
        return responseJsonList;
    }

}
