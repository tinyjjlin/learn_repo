package com.brs.oa.model;

import java.io.Serializable;

public class UserRole implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private Integer avaliable;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Integer avaliable) {
        this.avaliable = avaliable;
    }

    @Override
    public String toString() {
        return "user role==>code:"+this.getCode()+",name:"+this.getName();
    }



}
