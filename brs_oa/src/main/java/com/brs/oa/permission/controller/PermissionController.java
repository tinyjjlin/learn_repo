package com.brs.oa.permission.controller;


import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.permission.entity.Permission;
import com.brs.oa.permission.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@Api("权限管理模块")
@RestController
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 当前用户获取权限列表
     *
     * @param token
     * @return
     */
    @ApiOperation(value = " 当前用户获取权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户登录或获取的token值", dataType = "String",required = true)
    })

    @GetMapping("/api/personal/permission")
    public RestfulResult personalPermissionList(@RequestHeader("Authorization") String token,@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size) {
        Integer empNo = JwtSupport.getEmployeeNo(token);
        List <Permission> permissionList = permissionService.getPermissionList(empNo);
        PageInfo pageInfo = new PageInfo(permissionList);
        return new RestfulResult(200, "当前用户获取权限列表！", pageInfo);
    }

    /**
     *
     *获取权限列表
     * @param empNo
     * @return
     */
    @ApiOperation(value = " 根据员工号获取权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "empNo", value = "员工号", dataType = "int")
    })

    @GetMapping("/api/permission/empNo")
    public RestfulResult getpermissionListByEmp(@PathParam("empNo")Integer empNo,@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size) {
        List <Permission> permissionList = permissionService.getPermissionListByEmp(empNo);
        PageInfo pageInfo = new PageInfo(permissionList);
        return new RestfulResult(200, "获取权限列表！", pageInfo);
    }

    /**
     *
     *获取权限列表
     * @param roleNo
     * @return
     */
    @ApiOperation(value = "根据角色获取权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "roleNo", value = "角色编号", dataType = "int")
    })
    @GetMapping("/api/permission/roleNo")
    public RestfulResult getpermissionListByRole(@PathParam("roleNo")Integer roleNo,@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size) {
        List <Permission> permissionList = permissionService.getPermissionListByRole(roleNo);
        PageInfo pageInfo = new PageInfo(permissionList);
        return new RestfulResult(200, "获取权限列表！", pageInfo);
    }

    /**
     *
     *获取权限列表
     * @param permissionNo
     * @return
     */
    @ApiOperation(value = " 获取权限列表")
    @ApiImplicitParam(paramType = "query", name = "permissionNo", value = "权限编号", dataType = "int")
    @GetMapping("/api/permission")
    public RestfulResult permissionList(@PathParam("permissionNo")Integer permissionNo) {
        List <Permission> permissionList = permissionService.getPermissionList(permissionNo);
        PageInfo pageInfo = new PageInfo(permissionList);
        return new RestfulResult(200, "获取权限列表！", pageInfo);
    }










    @ApiOperation(value = " 添加新的权限")
    @PostMapping("/api/permission")
    public RestfulResult save(@RequestBody Permission permission){
        Integer result = permissionService.save(permission);
        return new RestfulResult(200,"添加权限成功",result );
    }

    @ApiOperation(value = " 编辑权限")
    @PatchMapping("/api/permission")
    public RestfulResult edit(@RequestBody Permission permission){
        Integer result = permissionService.edit(permission);
        return new RestfulResult(200,"编辑权限成功",result );
    }

    @ApiOperation(value = " 删除权限")
    @DeleteMapping("/api/permission")
    public RestfulResult delete(@PathParam("permissionNo")Integer permissionNo){
        Integer result = permissionService.delete(permissionNo);
        return new RestfulResult(200,"删除权限成功",result );
    }





}
