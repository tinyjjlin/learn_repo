package com.brs.oa.comm.apect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


//@Aspect
//@Component
public class QueryAspect {
    static final Logger LOG = LoggerFactory.getLogger(QueryAspect.class);

    @Pointcut("@annotation(com.brs.oa.comm.annotation.QueryAuth)")
    public void annotationPointCut(){}


    @Around("annotationPointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOG.info("@Around..........................before...");

       Object[] args = proceedingJoinPoint.getArgs();
        LOG.info("args----------->count:"+args.length);

       for (int i=0;i<args.length;i++){
           LOG.info("old arg value:"+args[i].toString());
       }
       //1动态修改方法的参数值
        /**
         * TODO 1 ==============================================================
         *    访问数据（字段权限表获取查询指定字段信息）
         */

       Object arg1 ="col_1,col_2,col_3";
       args[1]=arg1;
        //方法执行
        Object obj= proceedingJoinPoint.proceed(args);
        System.out.println("@Around：.......................after.......");

        /**
         * TODO  2 ===============================================================
         *  处理只显示其有权限查看的字段
         *  实体属性，和指定字段进行匹配过滤
         *
         */

        return obj;
    }


    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //从切面中获取当前方法
        Method method = signature.getMethod();
        LOG.info("method--------before---------------->"+method.getName());
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        LOG.info("new args------------------------------------->"+args);
    }
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        LOG.info("method--------after--------------------------->");
    }



}
