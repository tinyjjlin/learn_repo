package com.brs.oa.role.controller;

import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.role.entity.Role;
import com.brs.oa.role.service.IRoleService;
import com.brs.oa.role.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */

@Api("角色管理模块")
@RestController
public class RoleController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private IRoleService roleService;

    /**
     * 查看角色列表
     * @return
     */
    @ApiOperation(value = "查看角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "roleNo", value = "角色编号", dataType = "int")
    })
    @ApiImplicitParam(paramType = "query", name = "roleNo", value = "角色编号", dataType = "int")
    @GetMapping("/api/role")
    public RestfulResult getRoleList(@PathParam("roleNo") Integer roleNo,@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size){
        List<Role> roleVoList = roleService.getRoleList(roleNo);
        PageInfo pageInfo = new PageInfo(roleVoList);
        return new RestfulResult(200,"查看角色信息",pageInfo );
    }

    /**
     * 根据员工查看角色列表
     * @return
     */
    @ApiOperation(value = "根据员工查看角色列表")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "empNo", value = "员工编号", dataType = "int")
    })

    @GetMapping("/api/role/empNo")
    public RestfulResult getRoleListByEmp(@PathParam("empNo") Integer empNo,@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size){
        List<Role> roleVoList = roleService.getRoleListByEmp(empNo);
        PageInfo pageInfo = new PageInfo(roleVoList);
        return new RestfulResult(200,"查看角色信息",pageInfo );
    }

    /**
     * 查看角色权限信息
     * @return
     */
    @ApiOperation(value = "查看角色权限信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "roleNo", value = "角色编号", dataType = "int")
    })

    @GetMapping("/api/role&permission")
    public RestfulResult getRolePermissionList(@PathParam("roleNo") Integer roleNo,@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size){
        List<RoleVo> roleVoList = roleService.getRolePermissionList(roleNo);
        PageInfo pageInfo = new PageInfo(roleVoList);
        return new RestfulResult(200,"查看角色权限信息",pageInfo );
    }


    /**
     * 添加新的角色
     * @param role
     * @return
     */
    @ApiOperation(value = "添加新的角色")
    @PostMapping("/api/role")
    public RestfulResult add(@RequestBody Role role) {
       int result = roleService.save(role);
       return new RestfulResult(200, "添加角色操作成功！",result);
    }

    /**
     *删除角色
     * @param roleNo
     * @return
     */
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/api/role")
    public RestfulResult delete(@PathParam("roleNo")Integer roleNo){
        int result = roleService.delete(roleNo);
        return new RestfulResult(200, "删除角色操作成功！",result);
    }

    /**
     * 角色添加权限
     */
    @ApiOperation(value = "角色添加权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "roleNo", value = "角色编号", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "body", name = "permissionNoList", value = "权限列表", dataType = "Array", required = true)
    })

    @PostMapping("/api/role/bindPermission")
    public RestfulResult bindPermission(@RequestParam("roleNo")Integer roleNo,@RequestBody List<Integer>permissionNoList){
        int result =roleService.bindPermission(roleNo, permissionNoList);
        return new RestfulResult(200, "角色添加权限操作成功！",result);
    }
}
