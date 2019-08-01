package com.brs.oa.comm.apect;

import com.brs.oa.comm.annotation.ResponseFieldAuth;
import com.brs.oa.model.EntityType;
import com.brs.oa.model.RestfulResultData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.List;


@Aspect
@Configuration
public class ResponseFieldAuthAspect {
    static final Logger LOG = LoggerFactory.getLogger(ResponseFieldAuthAspect.class);

    @Pointcut("@annotation(com.brs.oa.comm.annotation.ResponseFieldAuth)")
    public void annotationPointCut(){}


    @Around("annotationPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOG.info("@Around：.......................before.......");

        // 方法执行,返回实体对象
        Object obj= proceedingJoinPoint.proceed();

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();

        ResponseFieldAuth responseFieldAuth =method.getAnnotation(ResponseFieldAuth.class);
        EntityType entityType = responseFieldAuth.type();
        Class entityClass = responseFieldAuth.entityClass();

        LOG.info("data type"+ obj);
        if(obj instanceof RestfulResultData){
            RestfulResultData restfulResultData = (RestfulResultData) obj;
            Object data = restfulResultData.getData();
            if(data instanceof List){
                List<Object> list = (List<Object>) data;
                for (int i=0;i<list.size();i++){
                    LOG.info("list -->obj---->"+list.get(i)+"---------->"+list.get(i).toString());
                    Object object = list.get(i);
                    if(object.getClass().toString().equals(entityClass.toString())){

                    }
                }
                LOG.info(data.getClass().toString());
            }


        }
        return obj;
    }



}
