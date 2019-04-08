package com.brs.oa.permission.service;
import com.brs.oa.permission.entity.Permission;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface IPermissionService  {

    /**
     * 根据员工获取其所有权限信息
     * @param empNo
     * @return
     */
    public List<Permission> getPermissionListByEmp(Integer empNo);

    /**
     *
     * @param roleNo
     * @return
     */
    public List<Permission> getPermissionListByRole(Integer roleNo);

    /**
     *
     * @param permissionNo
     * @return
     */
    public List<Permission> getPermissionList(Integer permissionNo);

    public int  save(Permission permission);
    public int edit(Permission permission);
    public int delete(Integer permissionNo);

}
