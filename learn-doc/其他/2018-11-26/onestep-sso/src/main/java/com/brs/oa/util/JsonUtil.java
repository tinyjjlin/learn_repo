package com.brs.oa.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.brs.oa.comm.fieldAuth.FieldSchema;
import com.brs.oa.model.Salary;
import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.internal.dynalink.beans.StaticClass;
import org.apache.commons.collections.functors.FalsePredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.*;


public class JsonUtil {
    static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);


    /**
     * 请求json对象中包含不可操作的字段是返回不匹配，操作不合法。
     * @param jsonObject
     * @param columnMap
     * @return
     */
    public static Boolean  requestJsonMatch(JSONObject jsonObject, Map<String, FieldSchema> columnMap){
        Set<String> illegalKeys = getUnAccessableKeySet(jsonObject, columnMap);
        return  illegalKeys.size()>0?false:true;
    }

    /**
     * jsonObject 根据指定过滤规则，删除不用显示的key:value。
     * @param jsonObject
     * @param columnMap
     * @return
     */
    public static JSONObject jsonFilter(JSONObject jsonObject, Map<String, FieldSchema> columnMap) {
        Set<String> deleteKeys =getUnAccessableKeySet(jsonObject,columnMap );
        for(String key:deleteKeys){
            if(jsonObject.containsKey(key)){
                jsonObject.remove(key);
            }
        }
        return jsonObject;
    }

    /**
     * 获取json对象中不可访问字段集合
     * @param jsonObject
     * @param columnMap
     * @return
     */
    public static Set<String> getUnAccessableKeySet(JSONObject jsonObject, Map<String, FieldSchema> columnMap){
        Set<String> sameKeys = new HashSet <>();
        Set <String> keySet = jsonObject.keySet();
        for(String key :keySet){
            LOG.info("key=========>"+key);
            FieldSchema fieldSchema = columnMap.get(key);
            if (fieldSchema != null && fieldSchema.getAccessable() == 0) {
                sameKeys.add(key);
            }
        }
        return  sameKeys;
    }



    public static JSONObject responseJson(Integer code, String msg) {

        return responseJson(code, msg, null);
    }

    /**
     * controller 返回json 类型数据
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static JSONObject responseJson(Integer code, String msg, JSONObject data) {
        JSONObject responseJson = new JSONObject();
        responseJson.put("code", code);
        responseJson.put("msg", msg);
        responseJson.put("data", data);
        return responseJson;
    }


    public static JSONObject responseJsonMatch(JSONObject responseJson, String fieldRule) {
        JSONObject jsonObject = new JSONObject();

        String[] fields = fieldRule.split(",");
        Set <String> keySet = responseJson.keySet();
        Iterator <String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            //    LOG.info("key============>" + key);

            for (String field : fields) {
                //     LOG.info("field============>" + field);
                if (key.equals(field)) {
                    jsonObject.put(key, responseJson.get(key));
                    break;
                }
            }
        }

        return jsonObject;
    }

    public static boolean requestParamsMatch(JSONObject requestJson, String fieldRule) {
        String[] fields = fieldRule.split(",");
        Set <String> keySet = requestJson.keySet();

        Iterator <String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            //   LOG.info("key============>"+key);
            Boolean hasExist = false;
            for (String field : fields) {
                //     LOG.info("field============>"+field);
                if (key.equals(field)) {
                    hasExist = true;
                    break;
                }
            }
            if (!hasExist) {
                return hasExist;
            }
        }
        return true;
    }


    public static List <JSONObject> JavaList2JsonList(List <Object> list) {
        List <JSONObject> jsonObjectList = new ArrayList <>();
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(list.get(i));
            jsonObjectList.add(jsonObject);
        }
        return jsonObjectList;
    }


    public static void main(String[] args) {

        // JSONObject dataJson = new JSONObject();
        // dataJson.put("token", "jjjjjjjjjjjjjjjjjjjjj");
        //  LOG.info( JsonUtil.responseJson(200, "success",dataJson ).toJSONString());

        JSONObject requestJson = new JSONObject();
        requestJson.put("col_3", "jjlin");
        requestJson.put("col_2", "jjlin");
        requestJson.put("col_5", "jjlin");
        requestJson.put("col_1", "jjlin");

        String filedsRule = "col_1,col_2,col_3";

        Boolean result = JsonUtil.requestParamsMatch(requestJson, filedsRule);
        // LOG.info("result:"+result);

        //  LOG.info(JsonUtil.responseJsonMatch(requestJson, filedsRule).toJSONString());

        Salary salary = new Salary();
        salary.setUser_uid(100057);
        salary.setCol_1("a");
        salary.setCol_2("b");

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(salary);
        LOG.info(jsonObject.toJSONString());
        LOG.info(JsonUtil.responseJsonMatch(jsonObject, filedsRule).toJSONString());

    }
}
