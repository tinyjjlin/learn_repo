package com.brs.oa.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private String name;
    private String pwd;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUid() {
        return uid;
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

    @Override
    public String toString() {
        return "user==>uid:"+this.getUid()+",name:"+this.getName();
    }

}
