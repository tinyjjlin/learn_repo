package com.brs.oa.role.vo;

import com.brs.oa.permission.entity.Permission;
import lombok.Data;
import java.util.List;

/**
 * @author tiny lin
 * @date 2018/11/29
 */

@Data
public class RoleVo {

    private Integer roleNo;

    private String roleDesc;

    private Integer isEnabled;

    private String roleName;

    private List<Permission> permissionList;
}
