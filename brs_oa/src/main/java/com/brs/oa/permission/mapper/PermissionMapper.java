package com.brs.oa.permission.mapper;

import com.brs.oa.permission.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface PermissionMapper {


    /**
     * 获取权限列表
     * @param permissionNo
     * @return
     */
    List<Permission> selectPermissionList(@Param("permissionNo")Integer permissionNo);
    /**
     * 获取权限列表(根据员工号)
     * @param empNo
     * @return
     */
    List<Permission> selectPermissionListByEmp(@Param("empNo")Integer empNo);


    /**
     * 获取角色绑定的权限
     * @param roleNo
     * @return
     */
    List<Permission> selectPermissionListByRole(@Param("roleNo")Integer roleNo);

    /**
     * 添加
     * @param permission
     * @return
     */
    int insert(@Param("permission") Permission permission);

    /**
     * 更新
     * @param permission
     * @return
     */
    int update(@Param("permission") Permission permission);

    /**
     * 删除
     * @param permissionNo
     * @return
     */
    int delete(@Param("permissionNo")Integer permissionNo);
}
