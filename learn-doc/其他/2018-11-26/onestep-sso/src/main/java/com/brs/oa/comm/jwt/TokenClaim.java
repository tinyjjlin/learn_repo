package com.brs.oa.comm.jwt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TokenClaim {
    private Date expireTime;
    private Integer userId;
   // private List<String> userRoleList= new ArrayList <>();
  //  private List<String> userPermissionList =new ArrayList <>();
    private String[] userRoles;
    private String[] userPermissions;


    public String[] getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }

    public String[] getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(String[] userPermissions) {
        this.userPermissions = userPermissions;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

//    public List <String> getUserRoleList() {
//        return userRoleList;
//    }
//
//    public List <String> getUserPermissionList() {
//        return userPermissionList;
//    }



    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

//    public void setUserRoleList(String value) {
//        this.userRoleList.add(value);
//    }
//
//    public void setUserPermissionList(String value) {
//        this.userPermissionList.add(value);
//    }
}
