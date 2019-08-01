package com.brs.oa.comm.fieldAuth;

public class FieldSchema {
    private String field_name;
    private String field_desc;
    private String from_dto;
    private Integer accessable;

    public Integer getAccessable() {
        return accessable;
    }

    public void setAccessable(Integer accessable) {
        this.accessable = accessable;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getField_desc() {
        return field_desc;
    }

    public void setField_desc(String field_desc) {
        this.field_desc = field_desc;
    }

    public String getFrom_dto() {
        return from_dto;
    }

    public void setFrom_dto(String from_dto) {
        this.from_dto = from_dto;
    }
}
