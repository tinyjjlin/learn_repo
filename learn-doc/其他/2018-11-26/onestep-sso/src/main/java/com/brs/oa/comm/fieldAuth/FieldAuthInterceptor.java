package com.brs.oa.comm.fieldAuth;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.brs.oa.service.impl.FieldServiceImpl;
import com.brs.oa.util.CommonUtil;
import com.brs.oa.util.JsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

@Aspect
@Component
public class FieldAuthInterceptor {

    static final Logger LOG = LoggerFactory.getLogger(FieldAuthInterceptor.class);
    @Autowired
    private FieldServiceImpl fieldService;

    static final Logger LOGGER = LoggerFactory.getLogger(FieldAuthInterceptor.class);

    @Pointcut("@annotation(com.brs.oa.comm.fieldAuth.QueryFilter)")
    public void queryMethodPointcut() {
    }


    @Around(value = "queryMethodPointcut()")
    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = joinPoint.proceed();

        // 获取用户code， dtoName
        String userCode = getCurrentUserCode();
        String dtoName = getDtoName(joinPoint);
        LOG.info("dtoname-------------->" + dtoName);


        //=========================start=============================================
//        if (object != null) {
//            if (object instanceof Filterable) {
//                LOG.info("exe-------------------doFilter!" + object.getClass());
//                doFilter((Filterable) object, getFields(userCode, dtoName));
//            }
//        }
        //    return object;
        //=============================end===========================================

        return doFilter2(object, getFields(userCode, dtoName));
    }


    public Object doFilter2(Object o, List <FieldSchema> resources) {
        //数据权限表为空，则不用过滤
        if (CollectionUtils.isEmpty(resources)) {
            return o;
        }

        //根据权限列表，设置map
        Map <String, FieldSchema> columnMap = new HashMap <>(resources.size());
        for (FieldSchema column : resources) {
            //将字段名与权限表字段对应
            columnMap.put(column.getField_name(), column);
        }
        LOG.info("o-----type====class=====>" + o.getClass());
        if (o instanceof JSONArray) {
            JSONArray jsonArray2 = new JSONArray();
            JSONArray jsonArray = (JSONArray) o;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                LOG.info("jsonObject----------->" + jsonObject);
                jsonArray2.add(JsonUtil.jsonFilter(jsonObject, columnMap));
            }

            return jsonArray2;
        }

        if (o instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) o;
            return JsonUtil.jsonFilter(jsonObject, columnMap);
        }
        return o;

    }


    private void doFilter(Filterable filterable, List <FieldSchema> resources) {

        //数据权限表为空，则不用过滤
        if (CollectionUtils.isEmpty(resources)) {
            return;
        }
        filterable.doFilter(o -> {
            //根据权限列表，设置map
            Map <String, FieldSchema> columnMap = new HashMap <>(resources.size());

            for (FieldSchema column : resources) {
                //将字段名与权限表字段对应
                columnMap.put(column.getField_name(), column);
            }
            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(o.getClass());
            LOGGER.info("o----------------class:" + o.getClass());
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();


                //获取实体对象的所有属性名称
                FieldSchema dataColumn = columnMap.get(name);

                if (dataColumn != null && dataColumn.getAccessable() == 0) {
                    try {
                        LOGGER.info("propertyDescriptor---------------->" + dataColumn.getField_name() + ",accessable:" + dataColumn.getAccessable());
                        propertyDescriptor.getWriteMethod().invoke(o, new Object[]{null});
                    } catch (Exception e) {

                    }


                }
            }
            return o;
        });
    }


    public String getCurrentUserCode() {
        RequestAttributes rs = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes srs = (ServletRequestAttributes) rs;
        HttpServletRequest request = srs.getRequest();
        String reqURI = request.getRequestURI();
        String userCode = CommonUtil.getCurrentUserCodeFromToken(request);
        return userCode;
    }

    public String getDtoName(ProceedingJoinPoint joinPoint) {
        String dtoName = "";
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        QueryFilter queryFilter = method.getAnnotation(QueryFilter.class);
        if (queryFilter != null) {
            dtoName = queryFilter.dtoName();
        }
        return dtoName;
    }

    public List <FieldSchema> getFields(String userCode, String dtoName) {
        List <FieldSchema> fieldSchemas = null;
        if (!StringUtils.isEmpty(dtoName) && !StringUtils.isEmpty(userCode)) {

            fieldSchemas = fieldService.findFieldByUserCodeAndDToName(userCode, dtoName);
        }
        for (int i = 0; i < fieldSchemas.size(); i++) {
            LOG.info("field name ==========================>" + fieldSchemas.get(i).getField_name());
        }
        return fieldSchemas;
    }

}
