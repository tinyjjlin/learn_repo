//package com.brs.oa.comm.apect;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.brs.oa.util.CommonUtil;
//import com.brs.oa.util.JsonUtil;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Aspect
//@Configuration
//public class FieldAuthAspect {
//    static final Logger LOG = LoggerFactory.getLogger(FieldAuthAspect.class);
//
//    @Pointcut("@annotation(com.brs.oa.comm.annotation.ResponseFieldAuth)")
//    public void annotationPointCut(){}
//
//
//    @Around("annotationPointCut()")
//    public List<JSONObject> doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        LOG.info("@Around：.......................before.......");
//
//        RequestAttributes rs =RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes srs= (ServletRequestAttributes) rs;
//        HttpServletRequest request= srs.getRequest();
//        //  HttpServletResponse response = srs.getResponse();
//        String reqURI =request.getRequestURI();
//        LOG.info("apect---------------------request uri:"+reqURI);
//        Integer userId = CommonUtil.getCurrentUserIdFromToken(request);
//
////        //允许当前用户操作的字段(数据库保存字段规则)
////        String  fieldRule ="a,b,c";
////        //规定post传给controller的数据是json
////        Object[] args = proceedingJoinPoint.getArgs();
////        JSONObject requestJson = (JSONObject)args[0];
////        // 字段匹配
////        if(JsonUtil.requestParamsMatch(requestJson, fieldRule)){
////            Object obj= proceedingJoinPoint.proceed(args);
////            LOGGER.info("@Around：.......................after.......");
////        }else{
////
////        }
//
//        /**
//         * 处理返回字段限制
//         */
//        // 方法执行,返回实体对象
//        Object obj= proceedingJoinPoint.proceed();
//        LOG.info("@Around：.......................after.......");
//        // 查询数据，获取字段规则信息
//        String  fieldRule ="user_uid,col_1,col_2,col_3";
//
//        List<JSONObject> returnList =(List<JSONObject>) obj;
//        List<JSONObject> responseJsonList = new ArrayList <>();
//
//        for(int i=0;i<returnList.size();i++){
//            JSONObject newJsonObject =JsonUtil.responseJsonMatch(returnList.get(i),fieldRule );
//            LOG.info("new json object =======================>"+newJsonObject.toJSONString());
//            responseJsonList.add(newJsonObject);
//        }
//
//        //  JSONObject responseJsonOld=(JSONObject) JSONObject.toJSON(obj);
//        // JSONObject  responseJsonData = JsonUtil.responseJsonMatch(responseJsonOld,fieldRule );
//
//        returnList=null;
//
//        return responseJsonList;
//    }
//
//
//
//}
