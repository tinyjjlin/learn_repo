package com.brs.oa.role.service;

import com.brs.oa.role.entity.Role;
import com.brs.oa.role.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface IRoleService {

   public int save(Role role);

   public int edit(Role role);

   public int delete(Integer roleNo);


    /**
     * 编辑角色权限
     * @return
     */
   public int saveRolePermission(Integer roleNo,List<Integer> permissionNoList);



    /**
     * 根据员工工号获取角色名称列表
     * @param empNo
     * @return
     */
    public List<String> getRoleNamesByEmpNo(Integer empNo);


    public List<Role> getRoleList(Integer roleNo);


    /**
     * 根据员工号获取角色列表
     * @param
     * @return
     */
    List<Role> getRoleListByEmp(Integer empNo);


    /**
     * 根据角色名称获取角色权限信息
     * @param roleNo
     * @return
     */
    public  List<RoleVo> getRolePermissionList(Integer roleNo);


    /**
     *为角色绑定权限
     * @param roleNo
     * @param permissionList
     * @return
     */
    int bindPermission(Integer roleNo,List<Integer> permissionList);



}
