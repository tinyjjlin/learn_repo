package com.brs.oa.model.dto;

import com.brs.oa.model.Permission;

import java.util.List;

public class UserDTO {
    private Integer uid;
    private String name;
    private String pwd;
    private String code;



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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
