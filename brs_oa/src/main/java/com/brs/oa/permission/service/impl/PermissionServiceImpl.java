package com.brs.oa.permission.service.impl;

import com.brs.oa.permission.entity.Permission;
import com.brs.oa.permission.mapper.PermissionMapper;
import com.brs.oa.permission.service.IPermissionService;
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
public class PermissionServiceImpl  implements IPermissionService {

    @Autowired(required = false)
    private PermissionMapper permissionMapper;

    @Override
    public List <Permission> getPermissionListByEmp(Integer empNo) {
        return permissionMapper.selectPermissionListByEmp(empNo);
    }

    @Override
    public List <Permission> getPermissionListByRole(Integer roleNo) {
        return permissionMapper.selectPermissionListByRole(roleNo);
    }

    @Override
    public List <Permission> getPermissionList(Integer permissionNo) {
        return permissionMapper.selectPermissionList(permissionNo);
    }

    @Override
    public int save(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int edit(Permission permission) {
        return permissionMapper.update(permission);
    }

    @Override
    public int delete(Integer permissionNo) {
        return permissionMapper.delete(permissionNo);
    }

}
