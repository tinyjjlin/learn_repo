package com.brs.oa.salary.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 工资项目
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalaryEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 项目分类
     */
    private String category;

    /**
     * 项目说明
     */
    private String itemText;

    /**
     * 项目值
     */
    private String itemValue;

    /**
     * 0代表固定项;1代表计算项
     */
    private Integer itemType;

    private String itemFormula;


}
