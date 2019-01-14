package com.brs.oa.department.service.impl;


import com.brs.oa.department.entity.Department;
import com.brs.oa.department.mapper.DepartmentMapper;
import com.brs.oa.department.service.IDepartmentService;

import com.brs.oa.department.vo.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public Integer add(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public Integer edit(Department department) {
        return departmentMapper.update(department);
    }

    @Override
    public Integer delete(Integer deptNo) {
        return departmentMapper.delete(deptNo);
    }

    @Override
    public List<Department> getDeptList() {
        return departmentMapper.selectList();
    }

    @Override
    public List <DepartmentVo> getDepartmentVoList() {
        return departmentMapper.selectDepartmentVoList();
    }
}
