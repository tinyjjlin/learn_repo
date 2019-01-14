package com.brs.oa.role.service.impl;

import com.brs.oa.role.entity.Role;
import com.brs.oa.role.mapper.RoleMapper;
import com.brs.oa.role.service.IRoleService;
import com.brs.oa.role.vo.RoleVo;
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
public class RoleServiceImpl implements IRoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Override
    public List <String> getRoleNamesByEmpNo(Integer empNo) {
        return roleMapper.queryRoleNamesByEmpo(empNo);
    }

    @Override
    public List <Role> getRoleListByEmp(Integer empNo) {
        return roleMapper.selectRoleListByEmp(empNo);
    }

    @Override
    public List <Role> getRoleList(Integer roleNo) {
        return roleMapper.selectRoleList(roleNo);
    }
    @Override
    public List <RoleVo> getRolePermissionList(Integer roleNo) {
        return roleMapper.selectRolePermissionList(roleNo);
    }


    @Override
    public int save(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int edit(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int bindPermission(Integer roleNo, List <Integer> permissionList) {
        return roleMapper.appendRolePermission(roleNo,permissionList );
    }

    @Override
    public int delete(Integer roleNo) {
        return roleMapper.delete(roleNo);
    }



    @Override
    public int saveRolePermission(Integer roleNo, List <Integer> permissionNoList) {
        return roleMapper.saveRolePermissionList(roleNo,permissionNoList);
    }


}
