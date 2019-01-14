package com.brs.oa.comm.interceptor;

import com.alibaba.fastjson.JSONObject;

import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.annotation.NeedPermissions;
import com.brs.oa.comm.annotation.RequestFieldAuth;
import com.brs.oa.comm.filter.StreamHttpServletRequestWrapper;
import com.brs.oa.comm.jwt.JwtSupport;

import com.brs.oa.login.service.ITokenService;
import com.brs.oa.util.CommonUtil;
import com.brs.oa.util.JsonUtil;
import com.brs.oa.util.StrUtil;
import com.brs.oa.permission.entity.Permission;
import com.brs.oa.permission.service.IPermissionService;
import com.brs.oa.vofield.service.IVoFieldService;
import com.brs.oa.vofield.vo.FieldVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @className AuthInterceptor
 * @description TODO
 * @author tiny lin
 * @date  2018/11/27
 * @version 1.0
*/
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    static final Logger LOG = LoggerFactory.getLogger(AuthInterceptor.class);
    @Autowired(required = false)
    private IVoFieldService fieldService;

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return handleAuth2( request,  response,  handler);
    }

    private boolean  handleAuth(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 对指定controller 进行拦截
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LOG.info("interceptor controller ====================>" + method.getName());

            Authentication authentication = method.getAnnotation(Authentication.class);
            NeedPermissions needPermissions = method.getAnnotation(NeedPermissions.class);
            RequestFieldAuth requestFieldAuth = method.getAnnotation(RequestFieldAuth.class);
            //step 1 : 只针对需要鉴权的annotation
            if (authentication != null || needPermissions != null || requestFieldAuth != null) {
                LOG.info("需要访问权限====================1================================》");
                //step 2: 验证 请求头部是否有 Authorization:token;没有返回消息没有权限调用，需要登录！
                String token = request.getHeader(CommonUtil.REQUEST_HEADER_KEY);
                if (StrUtil.isNUll(token)) {
                    return handleIllegalResponse(response, 404, "token不存在，需要登录！");
                }
                //step 3: token 验证 签名验证，过期时间验证
                Integer empNo = JwtSupport.getEmployeeNo(token);
                String[] permissionCodes = JwtSupport.getPermissionCodeList(token);
                if(permissionCodes != null){
                    for (int i = 0; i < permissionCodes.length; i++) {
                        LOG.info("permission----code" + permissionCodes[i]);
                    }
                }

                if (!JwtSupport.verifyToken(token)) {
                    return handleIllegalResponse(response, 404, "token不合法，token过期，需要登录！");
                }
                //TODO
                // step 4: 延长过期时间（）

                //step 5:判断是否有NeedPermissions 注解
                if (needPermissions != null) {
                    LOG.info("需要操作权限=================2=======================================》");
                    if (!StrUtil.matchPermission(needPermissions.value(), permissionCodes, needPermissions.logical())) {
                        return handleIllegalResponse(response, 404, "操作不合法，没有权限访问！");
                    }
                    //step 6: 判断当前路径是否需要进行字段权限验证
                    if (requestFieldAuth != null) {
                        LOG.info("字段操作是否合法=================3======================================》");
                        String voName = requestFieldAuth.dtoName();
                        LOG.info("empNo====>e" + empNo + ",============voName:" + voName);
                        Map <String, FieldVo> fieldMap = fieldService.getFieldMapByEmpNoAndVoName(empNo,voName );
                        if (!IsValidRequestField(request, fieldMap)) {
                            return handleIllegalResponse(response, 404, "请求字段不合法！");
                        }
                    }
                }

            }
        }

        return true;
    }

    private boolean  handleAuth2(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 对指定controller 进行拦截
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LOG.info("interceptor controller ====================>" + method.getName());

            Authentication authentication = method.getAnnotation(Authentication.class);
            NeedPermissions needPermissions = method.getAnnotation(NeedPermissions.class);
            RequestFieldAuth requestFieldAuth = method.getAnnotation(RequestFieldAuth.class);
            //step 1 : 只针对需要鉴权的annotation
            if (authentication != null || needPermissions != null || requestFieldAuth != null) {
                LOG.info("需要访问权限====================1================================》");
                //step 2: 验证 请求头部是否有 Authorization:token;没有返回消息没有权限调用，需要登录！
                String token = request.getHeader(CommonUtil.REQUEST_HEADER_KEY);
                if (StrUtil.isNUll(token)) {
                    return handleIllegalResponse(response, 404, "token不存在，需要登录！");
                }
                //step 3: token 验证 签名验证，过期时间验证
                Integer empNo = JwtSupport.getEmployeeNo(token);
                String[] permissionCodes = getPermissionCode(getPermissionListByEmpNo(empNo));
                if(permissionCodes != null){
                    for (int i = 0; i < permissionCodes.length; i++) {
                        LOG.info("permission----code" + permissionCodes[i]);
                    }
                }
                // redis 中token 验证
                 if(!tokenService.verifyToken(token)){
                     return handleIllegalResponse(response, 404, "token不合法，token过期，需要登录！");
                 }

                //step 5:判断是否有NeedPermissions 注解
                if (needPermissions != null) {
                    LOG.info("需要操作权限=================2=======================================》");
                    if (!StrUtil.matchPermission(needPermissions.value(), permissionCodes, needPermissions.logical())) {
                        return handleIllegalResponse(response, 404, "操作不合法，没有权限访问！");
                    }
                    //step 6: 判断当前路径是否需要进行字段权限验证
                    if (requestFieldAuth != null) {
                        LOG.info("字段操作是否合法=================3======================================》");
                        String voName = requestFieldAuth.dtoName();
                        LOG.info("empNo====>e" + empNo + ",============voName:" + voName);
                        Map <String, FieldVo> fieldMap = fieldService.getFieldMapByEmpNoAndVoName(empNo,voName );
                        if (!IsValidRequestField(request, fieldMap)) {
                            return handleIllegalResponse(response, 404, "请求字段不合法！");
                        }
                    }
                }

            }
        }


        return true;
    }

    /**
     * 获取权限 列表
    * @param empNo
    * @return java.util.List<com.brs.oa.brs.entity.Permission>
    */
    private List<Permission> getPermissionListByEmpNo(Integer empNo){
        return  permissionService.getPermissionList(empNo);
    }

    /**
     * 获取权限 数值
     * @param permissionList
     * @return
     */
    public static String[] getPermissionCode(List <Permission> permissionList) {
        Set<String> permissionCodeSet = new HashSet<>();
        for (int i = 0; i < permissionList.size(); i++) {
            String permissionCode = permissionList.get(i).getPermissionCode();
            if (!StringUtils.isEmpty(permissionCode)) {
                LOG.info("current user permission:=========>" + permissionCode);
                permissionCodeSet.add(permissionCode);
            }
        }
        return permissionCodeSet.toArray(new String[permissionCodeSet.size()]);
    }












    /**
     * 处理字段请求
     *
     * @param request, fieldSchemaMap
     * @return java.lang.Boolean
     */
    private Boolean IsValidRequestField(HttpServletRequest request, Map <String, FieldVo> fieldSchemaMap) throws IOException {
        String paramStr = new StreamHttpServletRequestWrapper(request).getParamStr();
        JSONObject paramJson = JSONObject.parseObject(paramStr);
        if (paramJson == null) {
            return true;
        }
        LOG.info("request param json=============>" + paramJson);

        return JsonUtil.requestJsonMatch(paramJson, fieldSchemaMap);
    }

    /**
     * 处理不合法的操作响应
     *
     * @param response, code, msg
     * @return java.lang.Boolean
     */
    private Boolean handleIllegalResponse(HttpServletResponse response, Integer code, String msg) {
        responseJsonResult(response, code, msg);
        return false;
    }

    private void responseJsonResult(HttpServletResponse response, int code, String msg) {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(JsonUtil.responseJson(code, msg));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
