package com.brs.oa.comm.fieldauth;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.brs.oa.comm.annotation.QueryFilter;
import com.brs.oa.util.CommonUtil;
import com.brs.oa.util.JsonUtil;
import com.brs.oa.vofield.service.IVoFieldService;
import com.brs.oa.vofield.vo.FieldVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author tiny lin
 * @version 1.0
 * @className FieldAuthInterceptor
 * @description TODO
 * @date 2018/11/27
 */
@Aspect
@Component
public class FieldAuthInterceptor {
    static final Logger LOG = LoggerFactory.getLogger(FieldAuthInterceptor.class);
    @Autowired(required=false)
    private IVoFieldService fieldService;

    static final Logger LOGGER = LoggerFactory.getLogger(FieldAuthInterceptor.class);

    @Pointcut("@annotation(com.brs.oa.comm.annotation.QueryFilter)")
    public void queryMethodPointcut() {
    }


    @Around(value = "queryMethodPointcut()")
    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("around befor------------------->");
        Object object = joinPoint.proceed();
        LOG.info("function excute------------------->");
        LOG.info("around after------------------->");
        Integer empNo = CommonUtil.getEmployeeNoFromRequest(getRequest());
        String voName = getVoName(joinPoint);
        LOG.info("empNo---    voName------------------->"+empNo+","+voName);
        Map <String, FieldVo> fieldSchemaMap = getFieldMap(empNo,voName );
        return doFilter2(object, fieldSchemaMap);
    }


    /**
     * @param
     * @author tiny
     * @date 2018/11/27
     * @method
     * @description TODO
     * @returnType
     */

    public Object doFilter2(Object o, Map <String, FieldVo> columnMap) {
        if (CollectionUtils.isEmpty(columnMap)) {
            return o;
        }
        /**
         * 返回数据字段过滤
         * ..........................................................................
         */
        //Object--->JSONObject
        if (o instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) o;
            return JsonUtil.jsonFilter(jsonObject, columnMap);
        }
        //List -->JSONArray
        if (o instanceof JSONArray) {
            JSONArray jsonArray2 = new JSONArray();
            JSONArray jsonArray = (JSONArray) o;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                jsonArray2.add(JsonUtil.jsonFilter(jsonObject, columnMap));
            }
            return jsonArray2;
        }
        return o;

    }



    /**
     * aop 获取请求
     * @return
     */
    public HttpServletRequest getRequest(){
        RequestAttributes rs = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes srs = (ServletRequestAttributes) rs;
        HttpServletRequest request = srs.getRequest();
        return request;
    }


    /**
     * @param joinPoint
     * @description 获取注解@QueryFilter 的值
     * @returnType java.lang.String
     * @author tiny
     * @date 2018/11/27
     */
    public String getVoName(ProceedingJoinPoint joinPoint) {
        String voName = "";
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        QueryFilter queryFilter = method.getAnnotation(QueryFilter.class);
        if (queryFilter != null) {
            voName = queryFilter.voName();
        }
        return voName;
    }

    /**
     * 获取字段map
     * @param empNo
     * @param voName
     * @return
     */
    public Map<String,FieldVo> getFieldMap(Integer empNo,String voName){
        return fieldService.getFieldMapByEmpNoAndVoName(empNo,voName );
    }
}
