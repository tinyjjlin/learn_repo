package com.brs.oa.comm.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.annotation.NeedPermissions;
import com.brs.oa.comm.annotation.RequestFieldAuth;
import com.brs.oa.comm.fieldAuth.FieldSchema;
import com.brs.oa.comm.filter.StreamHttpServletRequestWrapper;
import com.brs.oa.comm.jwt.JWTUtil;
import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.service.impl.FieldServiceImpl;
import com.brs.oa.util.JsonUtil;
import com.brs.oa.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    static final Logger LOG = LoggerFactory.getLogger(AuthInterceptor.class);
    @Autowired
    private FieldServiceImpl fieldService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
                String token = request.getHeader("Authorization");
                if (StrUtil.isNUll(token)) {
                    return handleIllegalResponse(response, 404, "token不存在，需要登录！");
                }
                //step 3: token 验证 签名验证，过期时间验证
                String userCode = JwtSupport.getUserCode(token, "userCode");
                String[] permissionCodes = JwtSupport.getArray(token, "permissionCodes");

                for (int i = 0; i < permissionCodes.length; i++) {
                    LOG.info("permission----code" + permissionCodes[i]);
                }

                if (!JwtSupport.verify(token, userCode)) {
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
                        String dtoName = requestFieldAuth.dtoName();
                        LOG.info("usercod====>e"+userCode+",============dtoName:"+dtoName);
                        Map <String, FieldSchema> fieldMap = fieldService.findFieldByUserCodeAndDToName2(userCode, dtoName);
                        if (!IsValidRequestField(request, fieldMap)) {
                            return handleIllegalResponse(response, 404, "请求字段不合法！");
                        }
                    }
                }

            }
        }

        return true;
    }


    //处理字段请求
    private Boolean IsValidRequestField(HttpServletRequest request, Map <String, FieldSchema> fieldSchemaMap) throws IOException {
        String paramStr = new StreamHttpServletRequestWrapper(request).getParamStr();
        JSONObject paramJson = JSONObject.parseObject(paramStr);
        if (paramJson == null) {
            return true;
        }
        LOG.info("request param json=============>"+paramJson);

        return JsonUtil.requestJsonMatch(paramJson, fieldSchemaMap);
    }

    //处理不合法的操作响应
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

    private Boolean requestURIMatch(String currentRequestURI, String authRequestURI) {
        String[] authRequestURIArr = authRequestURI.split(",");
        for (int i = 0; i < authRequestURIArr.length; i++) {
            if (currentRequestURI.equals(authRequestURIArr[i])) {
                return true;
            }
        }
        return false;
    }

//
//    public boolean handleAuth2(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 对指定controller 进行拦截
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//            LOG.info("interceptor controller ====================>" + method.getName());
//            String currentRequstURI = request.getRequestURI();
//            LOG.info("current ruquestURI ==============>" + currentRequstURI);
//
//            //step 1 : 只针对需要鉴权的请求路径进行拦截
//            String authRequestURI = "user/view,user/add,salary/view";
//            if (requestURIMatch(currentRequstURI, authRequestURI)) {
//                LOG.info("auth uri=============================================>");
//
//                //step 2: 验证 请求头部是否有 Authorization:token;没有返回消息没有权限调用，需要登录！
//                String token = request.getHeader("Authorization");
//                if (StrUtil.isNUll(token)) {
//                    return handleIllegalResponse(response, 404, "token不存在，需要登录！");
//                }
//
//                //step 3: token 验证 签名验证，过期时间验证
//                Integer userId = JWTUtil.getUserId(token, "userId");
//                if (!JWTUtil.verify(token, userId)) {
//                    return handleIllegalResponse(response, 404, "token不合法，token过期，需要登录！");
//                }
//                //TODO
//                // step 4: 延长过期时间（）
//
//                //step 5: 判断当前路径是否需要进行功能权限验证,不需要不用处理
//                String permissionRequestURI = "/user/view,/user/add/,/salary/view";
//                if (requestURIMatch(currentRequstURI, permissionRequestURI)) {
//                    //获取路径对应的权限，和当前用户的权限进行比较，没有权限直接返回
//                    Boolean permissionFlag = true;
//                    //当前用户没有对应操作权限
//                    if (!permissionFlag) {
//                        return handleIllegalResponse(response, 404, "操作不合法，没有权限访问！");
//                    }
//                    //step 6: 判断当前路径是否需要进行字段权限验证
//                    String fieldRequestURI = "salary/edit";
//                    if (requestURIMatch(currentRequstURI, permissionRequestURI)) {
//                        if (!IsValidRequestField(request)) {
//                            handleIllegalResponse(response, 404, "请求字段不合法！");
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
}

//
//    RequestFieldAuth accessAuth = method.getAnnotation(RequestFieldAuth.class);
//            if(accessAuth != null){
//                    // 获取request 参数 json
//                    String  paramStr = new StreamHttpServletRequestWrapper(request).getParamStr();
//                    JSONObject paramJson = JSONObject.parseObject(paramStr);
//
//                    LOG.info("interceptor: request param=====str=========>"+paramStr);
//                    LOG.info("interceptor: request param======json========>"+paramJson.toJSONString());
//
//                    //允许当前用户操作的字段(数据库保存字段规则)
//                    String  fieldRule ="a,b,c";
//                    if(JsonUtil.requestParamsMatch(paramJson, fieldRule)){
//                    return true;
//                    }else{
//                    // 直接返回404  json 提示信息
//                    response404(response);
//                    return false;
//                    }