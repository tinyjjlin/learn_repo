package com.brs.oa.util;


import com.alibaba.fastjson.JSONObject;

import com.brs.oa.vofield.vo.FieldVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author tiny lin
 * @version 1.0
 * @className JsonUtil
 * @description TODO
 * @date 2018/11/27
 */
public class JsonUtil {
    static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 请求json对象中包含不可操作的字段时返回false，操作不合法。
     *
     * @param jsonObject
     * @param columnMap
     * @return
     */
    public static Boolean requestJsonMatch(JSONObject jsonObject, Map <String, FieldVo> columnMap) {
        Set <String> illegalKeys = getUnAccessableKeySet(jsonObject, columnMap);
        return illegalKeys.size() > 0 ? false : true;
    }

    /**
     * 根据数据权限（字段权限）过滤掉不用显示的字段。
     *
     * @param jsonObject, columnMap
     * @return com.alibaba.fastjson.JSONObject
     */
    public static JSONObject jsonFilter(JSONObject jsonObject, Map <String, FieldVo> columnMap) {
        Set <String> deleteKeys = getUnAccessableKeySet(jsonObject, columnMap);
        for (String key : deleteKeys) {
            if (jsonObject.containsKey(key)) {
                jsonObject.remove(key);
            }
        }
        return jsonObject;
    }

    /**
     * 获取json对象中不可访问字段集合
     *
     * @param jsonObject, columnMap
     * @return java.util.Set<java.lang.String>
     */
    public static Set <String> getUnAccessableKeySet(JSONObject jsonObject, Map <String, FieldVo> columnMap) {
        Set <String> sameKeys = new HashSet <>();
        Set <String> keySet = jsonObject.keySet();
        for (String key : keySet) {
            LOG.info("key=========>" + key);
            FieldVo fieldSchema = columnMap.get(key);
            if (fieldSchema != null && fieldSchema.getIsEnabled() == 0) {
                sameKeys.add(key);
            }
        }
        return sameKeys;
    }


    /**
     * 返回json响应信息体
     *
     * @param code, msg
     * @return com.alibaba.fastjson.JSONObject
     */
    public static JSONObject responseJson(Integer code, String msg) {
        return responseJson(code, msg, null);
    }

    /**
     * 返回带有数据的json响应信息体
     *
     * @param code, msg, data
     * @return com.alibaba.fastjson.JSONObject
     */
    public static JSONObject responseJson(Integer code, String msg, JSONObject data) {
        JSONObject responseJson = new JSONObject();
        responseJson.put("code", code);
        responseJson.put("msg", msg);
        responseJson.put("data", data);
        return responseJson;
    }

}
