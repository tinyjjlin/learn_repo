package com.brs.oa.department.vo;

import com.brs.oa.staff.entity.Staff;
import lombok.Data;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/1/11
 */
@Data
public class DepartmentVo {

    private Integer deptId;
    private Integer deptNo;
    private String deptName;
    private Integer parentNo;

    private List<Staff>staffList;


}
