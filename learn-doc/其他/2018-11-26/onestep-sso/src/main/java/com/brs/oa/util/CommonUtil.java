package com.brs.oa.util;

import com.brs.oa.comm.jwt.JWTUtil;
import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonUtil {
    static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);


    /**
     * 从请求头部获取token，并解析获取用户信息 userCode
     *
     * @param request
     * @return
     */
    public static String getCurrentUserCodeFromToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
       String userCode=null;
        if (!StrUtil.isNUll(token)) {
           userCode = JwtSupport.getUserCode(token,"userCode" );
        }
        LOGGER.info("{current userId}.................." + userCode);
        return userCode;
    }


    //获取权限所有路径
    public static String[] getPermissionUrI(List <Permission> permissionList, String type) {

        String[] arr = new String[permissionList.size()];
        for (int i = 0; i < permissionList.size(); i++) {
            if (type.equalsIgnoreCase("menu")) {
                arr[i] = permissionList.get(i).getUrl();
            }
            if (type.equalsIgnoreCase("permission")) {
                arr[i] = permissionList.get(i).getUrl();
            }

        }
        return arr;
    }

    // 获取权限的code
    public static String[] getPermissionCode(List <Permission> permissionList) {
        Set <String> permissionCodeSet = new HashSet <>();
        for (int i = 0; i < permissionList.size(); i++) {
            String permissionCode = permissionList.get(i).getPre_code();
            if (!StringUtils.isEmpty(permissionCode)) {
                LOGGER.info("current user permission:=========>" + permissionCode);
                permissionCodeSet.add(permissionCode);
            }
        }

        return permissionCodeSet.toArray(new String[permissionCodeSet.size()]);
    }


    /**
     * List 去除重复元素
     *
     * @param list
     * @return
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

}
