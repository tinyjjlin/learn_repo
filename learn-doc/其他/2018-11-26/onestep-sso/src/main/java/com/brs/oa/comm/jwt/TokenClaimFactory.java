package com.brs.oa.comm.jwt;

import com.brs.oa.model.Permission;
import com.brs.oa.model.UserPermission;
import com.brs.oa.model.UserRole;
import com.brs.oa.service.LoginService;
import com.brs.oa.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TokenClaimFactory {
    static final Logger LOG = LoggerFactory.getLogger(TokenClaimFactory.class);

    public static TokenClaim createTokenClaim(LoginService loginService, Integer userId) {
        //  LOG.info("create tokenClaim-----userid..............." + userId);
        TokenClaim tokenClaim = new TokenClaim();
        //set
        tokenClaim.setUserId(userId);

        List <UserRole> roleList = loginService.findUserRole(userId);
        List <String> roleNameList = new ArrayList <>();
        List <String> permissionNameList = new ArrayList <>();
        for (int i = 0; i < roleList.size(); i++) {
            roleNameList.add(roleList.get(i).getName());
            // LOG.info("[tokenClaim]user role======================>"+roleList.get(i).getName()+",code"+roleList.get(i).getCode());
            List <UserPermission> permissionList = loginService.findUserPermissionByRoleCode(roleList.get(i).getCode());
            for (int k = 0; k < permissionList.size(); k++) {
                permissionNameList.add(permissionList.get(k).getName());
                //  LOG.info("user permisson......................." + permissionList.get(k).getName());
            }
        }
        //set
        tokenClaim.setUserRoles(roleNameList.toArray(new String[roleList.size()]));

        StrUtil.removeDuplicate(permissionNameList);
        for (int i = 0; i < permissionNameList.size(); i++) {
            // LOG.info("user permisson duplicate......................." + permissionNameList.get(i));
        }
        String[] permissionArr = new String[permissionNameList.size()];
        permissionNameList.toArray(permissionArr);
        //set
        tokenClaim.setUserPermissions(permissionArr);
        return tokenClaim;
    }


}
