package com.brs.oa.department.mapper;


import com.brs.oa.department.entity.Department;
import com.brs.oa.department.vo.DepartmentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface DepartmentMapper  {

    public Integer  insert(@Param("dept") Department department);

    public Integer  update(@Param("dept")Department department);

    public Integer delete(@Param("deptNo")Integer deptNo);

    public List<Department> selectList();

    public List<DepartmentVo> selectDepartmentVoList();

}
