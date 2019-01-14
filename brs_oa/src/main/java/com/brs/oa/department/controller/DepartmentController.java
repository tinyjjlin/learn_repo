package com.brs.oa.department.controller;

import com.brs.oa.comm.annotation.Authentication;

import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.department.entity.Department;
import com.brs.oa.department.service.IDepartmentService;
import com.brs.oa.department.vo.DepartmentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@RestController

@Api(value = "部门管理")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    /**
     * 查看公司所有部门信息列表
     * @return
     */
    @ApiOperation(value = "查看公司所有部门信息")
    @ApiResponse(code = 200,message = "查看部门信息",response = List.class)
    @GetMapping("/api/department")

    public RestfulResult getDeptList(){
        List<Department> departmentList= departmentService.getDeptList();
        return new RestfulResult(200,"获取部门列表",departmentList );
    }

    /**
     * 查看部门和员工信息
     * @return
     */
    @ApiOperation(value = "查看部门和员工信息")
    @ApiResponse(code = 200,message = "查看部门信息",response = List.class)
    @GetMapping("/api/department/more")
    @Authentication
    public RestfulResult getDeptAndStaffList(){
        List<DepartmentVo> departmentVoList= departmentService.getDepartmentVoList();
        return new RestfulResult(200,"查看部门和员工信息",departmentVoList );
    }



    /**
     * 添加信息的部门
     * @param department
     * @return
     */
    @ApiOperation(value = "添加新的部门")
    @PostMapping("/api/department")

    public RestfulResult add(@RequestBody Department department) {
        int result  =  departmentService.add(department);
        return new RestfulResult(200, "添加新的部门操作成功！") ;
    }

    /**
     * 一次添加多个新部门
     * @param departmentList
     * @return
     */
    @ApiOperation(value = "管理员添加多个新的部门")
    @PostMapping("/api/department/more")

    public RestfulResult addMutil(@RequestBody List <Department> departmentList) {
        Boolean result = false;
        if (departmentList != null) {

        }
        return result ? new RestfulResult(200, "添加部门操作成功！") : new RestfulResult(404, "添加部门操作失败！");
    }

    /**
     * 删除一个部门
     * @param deptNo
     * @return
     */
    @ApiOperation(value = "管理员删除一个部门")
    @DeleteMapping("/api/department")

    public RestfulResult delete(@RequestParam("deptNo")Integer deptNo){
       int result = departmentService.delete(deptNo);
        return new RestfulResult(200,"删除部门操作成功！",result );
    }


    /**
     * 一次删除多个部门
     * @param deptNoSet
     * @return
     */
    @ApiOperation(value = "管理员一次删除多个部门")
    @DeleteMapping("/api/department/more")

    public RestfulResult deleteMulti(@RequestBody List<Integer> deptNoSet){
        // request param verification
        //TODO
        return new RestfulResult(200,"删除多个部门操作成功！","" );
    }


    /**
     * 修改部门信息
     * @param department
     * @return
     */
    @ApiOperation(value = "管理员修改部门信息")
    @PatchMapping("/api/department")
    public RestfulResult edit(@RequestBody Department department){
         int result = departmentService.edit(department);
        return new RestfulResult(200,"编辑部门操作成功！" ,result);
    }
}
