package com.brs.oa.role.mapper;

import com.brs.oa.role.entity.Role;
import com.brs.oa.role.vo.RoleVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface RoleMapper{

    public int insert(@Param("role") Role role);

    public int update(@Param("role")Role role);

    public int delete(@Param("roleNo") Integer roleNo );

    /**
     * 为角色绑定权限
     * @param roleNo
     * @param permissionList
     * @return
     */
    public int saveRolePermissionList(@Param("roleNo")Integer roleNo, @Param("permissionNoList") List<Integer> permissionList);

    /**
     * 获取角色列表包含权限信息
     * @param roleNo
     * @return
     */
    List<RoleVo> selectRolePermissionList(@Param("roleNo")Integer roleNo);

    /**
     * 获取角色列表
     * @param roleNo
     * @return
     */
    List<Role> selectRoleList(@Param("roleNo")Integer roleNo);

    /**
     * 获取员工对应的角色列表
     * @param empNo
     * @return
     */
    List<Role> selectRoleListByEmp(@Param("empNo")Integer empNo);

    /**
     * 根据员工工号获取角色名称列表
     * @param empNo
     * @return
     */
    List<String> queryRoleNamesByEmpo(@Param("empNo")Integer empNo);


    /**
     * 为角色添加权限
     * @param roleNo
     * @param permissionList
     * @return
     */
    @Insert({
            "<script>",
            "insert into role_permission_relation(role_no,permission_no)values",
            "<foreach collection='permissionList' item='item' index='index' separator=','>",
            "(#{roleNo},#{item})",
            "</foreach>",
            "</script>"
    })
    int appendRolePermission(@Param("roleNo")Integer roleNo, @Param("permissionList") List<Integer> permissionList);



    /**
     * 插入新的角色
     * @param roleVo
     */
    @Insert("insert into brs_role(role_no,name,description,available)values(#{roleVo.roleNo},#{roleVo.name},#{roleVo.description},#{roleVo.available})")
    int append(@Param("roleVo") RoleVo roleVo);


    /**
     * 更新角色
     * @param roleVo
     * @return
     */
    @Update("update brs_role set name=#{roleVo.name},description=#{roleVo.description},available=#{roleVo.available} where role_no =#{roleVo.roleNo} ")
    int amend(@Param("roleVo") RoleVo roleVo);

    /**
     * 更新角色权限
     * @param roleNo
     * @param permissionList
     * @return
     */
    @Update({
            "<script>",
            "<foreach collection='permissionList' item='item' index='index' separator=','>",
            "update brs_role_permission",
            "set role_no=#{roleNo},permi_no=#{item}",
            "</foreach>",
            "</script>"
    })
    int amendRolePermission(@Param("roleNo")Integer roleNo, @Param("permissionList") List<Integer> permissionList);
}
