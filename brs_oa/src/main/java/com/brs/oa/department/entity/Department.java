package com.brs.oa.department.entity;


import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer deptId;
    private Integer deptNo;
    private String deptName;
    private Integer parentNo;

}
