package com.brs.oa.util;


import com.brs.oa.comm.jwt.JwtSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


/**
 * @author tiny lin
 * @version 1.0
 * @className CommonUtil
 * @description TODO
 * @date 2018/11/27
 */
public class CommonUtil {
    static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * 请求头部保存token的key
     */
    public final static String REQUEST_HEADER_KEY = "Authorization";

    /**
     * 从登录名字中，解析出工号 。
     * rule: username(j1000xx) empno(1000xx)
     * 登录名是由用户名首字母+工号
     * @return
     */
    public static Integer getEmpNo(String userName){
        Integer empNo;
        try {
            empNo = Integer.parseInt(userName.substring(1));
        }catch (Exception e){
            empNo =0;
        }
        return empNo;
    }

    /**
     * 从请求头部获取token
     *
     * @param request
     * @return
     */
    public static String getTokenFromRequest(HttpServletRequest request) {
        return request.getHeader(REQUEST_HEADER_KEY);
    }

    /**
     * 从请求头部获取token，并解析获取登录用户名
     *
     * @param request
     * @return
     */
    public static String getLoginNameFromRequest(HttpServletRequest request) {
        return JwtSupport.getLoginName(getTokenFromRequest(request));
    }

    /**
     * 从请求头部获取token，并解析获取登录员工号
     *
     * @param request
     * @return
     */
    public static Integer getEmployeeNoFromRequest(HttpServletRequest request) {
        return JwtSupport.getEmployeeNo(getTokenFromRequest(request));
    }

    /**
     * 从请求头部获取token，并解析获取员工所有权限列表
     *
     * @param request
     * @return
     */
    public String[] getPermissionCodeListFromRequest(HttpServletRequest request) {
        return JwtSupport.getPermissionCodeList(getTokenFromRequest(request));
    }


//    /**
//     * 从请求头部获取token，并解析获取员工号
//     * @param request
//     * @return
//     */
//    public static Integer getCurrentEmpNoFromToken(HttpServletRequest request) {
//        String token = request.getHeader(REQUEST_HEADER_KEY);
//        LOGGER.info("token"+token);
//        Integer empNo=0;
//        if (!StrUtil.isNUll(token)) {
//            empNo = JwtSupport.getEmpNo(token, JwtSupport.JWT_EMP_NO);
//        }
//        LOGGER.info("{current userId}...controller..............." + empNo);
//        return empNo;
//    }

//    /**
//     * 获取权限所有路径
//     *
//     * @param permissionList, type]
//     * @return java.lang.String[]
//     */
//    public static String[] getPermissionUrI(List <Permission> permissionList, String type) {
//
//        String[] arr = new String[permissionList.size()];
//        for (int i = 0; i < permissionList.size(); i++) {
//            if ("menu".equalsIgnoreCase(type)) {
//                arr[i] = permissionList.get(i).getUrl();
//            }
//            if ("permission".equalsIgnoreCase(type)) {
//                arr[i] = permissionList.get(i).getUrl();
//            }
//
//        }
//        return arr;
//    }

//    /**
//     * 获取权限code
//     * @param permissionList
//     * @return
//     */
//    public static String[] getPermissionCode(List <Permission> permissionList) {
//        Set <String> permissionCodeSet = new HashSet <>();
//        for (int i = 0; i < permissionList.size(); i++) {
//            String permissionCode = permissionList.get(i).getPermiCode();
//            if (!StringUtils.isEmpty(permissionCode)) {
//                LOGGER.info("current user permission:=========>" + permissionCode);
//                permissionCodeSet.add(permissionCode);
//            }
//        }
//
//        return permissionCodeSet.toArray(new String[permissionCodeSet.size()]);
//    }

//
//    /**
//     * List 去除重复元素
//     *
//     * @param list
//     * @return java.util.List
//     */
//    public static List removeDuplicate(List list) {
//        HashSet h = new HashSet(list);
//        list.clear();
//        list.addAll(h);
//        return list;
//    }

}
