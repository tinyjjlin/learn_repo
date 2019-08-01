//package com.brs.oa.config;
//import com.brs.oa.model.User;
//import com.brs.oa.model.UserPermission;
//import com.brs.oa.model.UserRole;
//import com.brs.oa.service.LoginService;
//import com.brs.oa.comm.jwt.JWTUtil;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
////@Service
//public class CustomRealm extends AuthorizingRealm {
//
//    private static final Logger LOGGER = LogManager.getLogger(CustomRealm.class);
//
//    @Autowired
//    private LoginService loginService;
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JWTToken;
//    }
//
//    /**
//     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//
//        String username = JWTUtil.getUsername(principals.toString());
//        User user = loginService.findUserByName(username);
//
//        // add role
//        List<UserRole> roleList = loginService.findUserRole(username);
//
//
//        Set<String > roleSet = new HashSet<>();
//        Set<String> permitSet = new HashSet<>();
//        for (int i=0;i<roleList.size();i++){
//            roleSet.add(roleList.get(i).getName());
//            List<UserPermission> userPermissions = loginService.findUserPermissionByRoleCode(roleList.get(i).getCode());
//            for(int j=0;j<userPermissions.size();j++){
//                permitSet.add(userPermissions.get(j).getName());
//            }
//
//        }
//
//
//
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles(roleSet);
//
//       // Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
//        simpleAuthorizationInfo.addStringPermissions(permitSet);
//        LOGGER.info("check 用户权限是调用----------------》"+username+",user role:");
//
//        return simpleAuthorizationInfo;
//    }
//
//    /**
//     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
//        String token = (String) auth.getCredentials();
//        // 解密获得username，用于和数据库进行对比
//        String username = JWTUtil.getUsername(token);
//        LOGGER.info("验证用户---------------》"+username);
//        if (username == null) {
//            throw new AuthenticationException("token invalid");
//        }
//
//        User user = loginService.findUserByName(username);
//        LOGGER.info("验证用户--userBean------------》"+user.getName()+",pwd:"+user.getPwd());
//        if (user == null) {
//            throw new AuthenticationException("User didn't existed!");
//        }
//
//        if (! JWTUtil.verify(token, username, user.getPwd())) {
//            LOGGER.info("jwt verify--------------------->");
//            throw new AuthenticationException("Username or password error");
//        }
//
//        return new SimpleAuthenticationInfo(token, token, "my_realm");
//    }
//}
