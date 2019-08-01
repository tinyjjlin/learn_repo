package com.brs.oa.model;

import java.util.List;

public class LoginUser {
    private Integer uid;
    private String name;
    private String pwd;
    private String code;

    private List <Permission> menus;
    private List <Permission> permissions;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUid(Integer uid) {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List <Permission> getMenus() {
        return menus;
    }

    public void setMenus(List <Permission> menus) {
        this.menus = menus;
    }

    public List <Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List <Permission> permissions) {
        this.permissions = permissions;
    }
}
