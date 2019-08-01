package com.brs.oa.model.entityModel;

public class FieldInfo {
    private String columName;
    private String javaName;
    private String javaType;
    private String descName;
    private Object value;

    public FieldInfo(String columName,String javaName,String javaType){
        this.columName= columName;
        this.javaName = javaName;
        this.javaType = javaType;
    }
    public String getColumName() {
        return columName;
    }

    public void setColumName(String columName) {
        this.columName = columName;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
