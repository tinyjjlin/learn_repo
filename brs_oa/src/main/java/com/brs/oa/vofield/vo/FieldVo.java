package com.brs.oa.vofield.vo;

import lombok.Data;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@Data
public class FieldVo {
    private String fieldName;
    private String fieldDesc;
    private String fieldType;
    private String fromVo;
    private Integer fieldNo;
    private Integer isEnabled;
}
