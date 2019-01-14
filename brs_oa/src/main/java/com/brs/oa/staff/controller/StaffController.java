package com.brs.oa.staff.controller;



import com.alibaba.fastjson.JSONObject;
import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.staff.entity.EducationRecord;
import com.brs.oa.staff.entity.TrainRecord;
import com.brs.oa.staff.entity.WorkRecord;
import com.brs.oa.staff.service.IStaffService;
import com.brs.oa.staff.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@RestController
@Api("员工管理模块")
public class StaffController {

    private static final Log LOG = LogFactory.getLog(StaffController.class);
    @Autowired
    private IStaffService staffService;




    /**
     * 角色添加权限
     */
    @ApiOperation(value = "角色添加权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "empNo", value = "员工号", dataType = "int", required = true)

    })
    @PostMapping("/api/staffs/bindRole")
    public RestfulResult bindRole(@RequestParam("empNo")Integer empNo,@RequestBody List<Integer>roleNoList){
        int result =staffService.bindRole(empNo,roleNoList );
        return new RestfulResult(200, "用户添加角色成功！",result);
    }





    /**
     * 查看公司所有员工信息列表（基本信息）
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页查看公司所有员工的基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/api/staffs")
    @Authentication
    public RestfulResult staffListFromCompany(@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size) {
        PageHelper.startPage(page,size );
        List <SimpleStaffVo> staffVoList = staffService.getStaffBaseInfoAll();
        PageInfo pageInfo = new PageInfo(staffVoList);
        return new RestfulResult(200, "查看公司所有员工的基本信息列表操作成功！", pageInfo);
    }

    /**
     * 查看指定部门的所有员工信息（基本信息）
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页查看指定部门的员工基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "deptNo", value = "指定部门编号", dataType = "int",required = true),
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "每页显示的数据行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/api/staff/deptNo/{deptNo}")
    @Authentication
    public RestfulResult staffListFromDepartment( @PathVariable(value = "deptNo") Integer deptNo, @RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size) {
        LOG.info("deptNo--------->"+deptNo);
        PageHelper.startPage(page,size );
        List <SimpleStaffVo> staffVoList = staffService.getStaffBaseInfoByDeptNo(deptNo);
        PageInfo pageInfo = new PageInfo(staffVoList);
        return new RestfulResult(200, "查看指定部门的所有员工信息列表操作成功！", pageInfo);
    }

    /**
     * 根据工号查看指定员工的基本信息
     * @param empNo
     * @return
     */
    @ApiOperation(value = "根据员工工号查看指定员工的基本信息")
    @ApiImplicitParam(paramType = "path", name = "staffId", value = "指定员工号", dataType = "int",required = true)
    @GetMapping("/api/staffs/{staffId}")
    @Authentication
    public RestfulResult searchStaffByEmpNo(@PathVariable("staffId") Integer empNo){
        SimpleStaffVo simpleSalaryVo = staffService.getStaffBaseInfo(empNo);
        return new RestfulResult(200, "根据员工工号查看指定员工的基本信息操作成功！", simpleSalaryVo);
    }
    /**
     * 根据员工姓名查看指定员工的基本信息
     * @param empName
     * @return
     */
    @ApiOperation(value = "根据员工姓名查看指定员工的基本信息")
    @ApiImplicitParam(paramType = "path", name = "staffName", value = "员工姓名", dataType = "String",required = true)
    @GetMapping("/api/staffs/name/{staffName}")
    @Authentication
    public RestfulResult searchStaffByEmpName(@RequestHeader("Authorization") String token,@PathVariable(value = "staffName") String empName){
        SimpleStaffVo simpleSalaryVo  = staffService.getStaffBaseInfo(empName);
        return new RestfulResult(200, "根据员工姓名查看指定员工的基本信息操作成功！", simpleSalaryVo);
    }

    /**
     *  根据员工工号，查看员工的详细信息
     * @return
     */
    @GetMapping("/api/staffs/{staffId}/info")
    @ApiOperation(value = " 根据员工工号，查看员工的详细信息")
    @ApiImplicitParam(paramType = "path", name = "staffId", value = "员工工号", dataType = "int",required = true)
    public RestfulResult searchStaffInfo(@PathVariable(value = "staffId")Integer empNo){

        StaffDetailInfo staffDetailInfo = staffService.getStaffDetailInfo(empNo);
        return new RestfulResult(200, "查看员工个人信息操作成功！", staffDetailInfo);
    }
    /**
     * 根据员工姓名， 查看员工的详细信息
     * @return
     */
    @GetMapping("/api/staffs/name/{staffName}/info")
    @ApiOperation(value = "根据员工姓名， 查看员工的详细信息")
    @ApiImplicitParam(paramType = "path", name = "staffName", value = "员工姓名", dataType = "String",required = true)
    public RestfulResult searchStaffInfo(@PathVariable(value = "staffName")String empName){

        StaffDetailInfo staffDetailInfo = staffService.getStaffDetailInfo(empName);
        return new RestfulResult(200, "查看员工个人信息操作成功！", staffDetailInfo);
    }

    /**
     *  员工查看自己的详细信息
     * @return
     */
    @GetMapping("/api/staffs/personal/info")
    @ApiOperation(value = "员工查看个人的详细信息")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户登录或获取的token值", dataType = "String",required = true)
    public RestfulResult searchPersonalInfo(@RequestHeader("Authorization") String token){
        Integer empNo = JwtSupport.getEmployeeNo(token);
        StaffDetailInfo staffDetailInfo = staffService.getStaffDetailInfo(empNo);
        LOG.info("request---token>"+token);
        return new RestfulResult(200, "查看员工个人信息操作成功！", staffDetailInfo);
    }

    /**
     * 编辑个人详细信息
     * @param token
     * @return
     */
    @PatchMapping("/api/staffs/info")
    @ApiOperation(value = "员工编辑个人详细信息")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult eidtPersonalInfo(@RequestHeader("Authorization") String token, @RequestBody StaffDetailVo staffDetailVo){
        LOG.info("request---token>"+token);
        return new RestfulResult(200, "查看员工个人信息操作成功！", null);
    }

    /**
     * 编辑个人基本信息
     * @param token
     * @return
     */
    @PatchMapping("/api/staffs/personal/baseInfo")
    @ApiOperation(value = "员工编辑个人基本信息")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult editBaseInfo(@RequestHeader("Authorization") String token, @RequestBody StaffBaseInfoVo baseInfoVo){
        LOG.info("request---token>"+token);
        int result = staffService.editBaseInfoByEmpNo(baseInfoVo);
        return new RestfulResult(200, "编辑个人基本信息操作成功！", result);
    }

    /**
     * 编辑个人重要信息
     * @param token
     * @return
     */
    @PatchMapping("/api/staffs/personal/importantInfo")
    @ApiOperation(value = "员工编辑个人重要信息")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult editImportantInfo(@RequestHeader("Authorization") String token, @RequestBody StaffImportantInfoVo importantInfoVo){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(importantInfoVo));
        int result = staffService.editImportantInfoByEmpNo(importantInfoVo);
        return new RestfulResult(200, "编辑个人重要信息操作成功！", result);
    }

    /**
     * 插入或更新教育经历（记录）
     * @param token
     * @return
     */
    @PatchMapping("/api/staffs/addUpdate/eduInfo")
    @ApiOperation(value = "员工编辑个人重要信息")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult insertOrUpdateEduRecord(@RequestHeader("Authorization") String token, @RequestBody EducationRecord educationRecord){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(educationRecord));
        int result = staffService.insertOrUpdateEduRecord(educationRecord);
        return new RestfulResult(200, "编辑个人重要信息操作成功！", result);
    }

    /**
     * 删除教育经历（记录）
     * @param token
     * @return
     */
    @DeleteMapping("/api/staffs/personal/eduInfo/{eduRecordId}")
    @ApiOperation(value = "删除教育经历")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult deleteEduRecord(@RequestHeader("Authorization") String token, @PathVariable("eduRecordId")Integer eduRecordId){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ eduRecordId);
        int result = staffService.deleteEduRecordById(eduRecordId);
        return new RestfulResult(200, "删除教育经历操作成功！", result);
    }

    /**
     * 新增教育经历（记录）
     * @param token
     * @return
     */
    @PostMapping("/api/staffs/personal/eduInfo")
    @ApiOperation(value = "新增教育经历")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult addEduRecord(@RequestHeader("Authorization") String token, @RequestBody EducationRecord educationRecord){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(educationRecord));
        int result = staffService.insertEduRecord(educationRecord);
        return new RestfulResult(200, "新增教育经历！", result);
    }

    /**
     * 更新教育经历（记录）
     * @param token
     * @return
     */
    @PatchMapping("/api/staffs/personal/eduInfo")
    @ApiOperation(value = "更新教育经历（记录）")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult editEduRecord(@RequestHeader("Authorization") String token, @RequestBody EducationRecord educationRecord){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(educationRecord));
        int result = staffService.updateEduRecord(educationRecord);
        return new RestfulResult(200, "更新教育经历操作成功！", result);
    }











    /**
     * 删除工作经历（记录）
     * @param token
     * @return
     */
    @DeleteMapping("/api/staffs/personal/workRecord/{workRecordId}")
    @ApiOperation(value = "删除工作经历")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult deleteWorkRecord(@RequestHeader("Authorization") String token, @PathVariable("workRecordId")Integer workRecordId){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ workRecordId);
        int result = staffService.deleteWorkRecord(workRecordId);
        return new RestfulResult(200, "删除工作经历操作成功！", result);
    }

    /**
     * 新增工作经历（记录）
     * @param token
     * @return
     */
    @PostMapping("/api/staffs/personal/workRecord")
    @ApiOperation(value = "新增工作经历")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult addWorkRecord(@RequestHeader("Authorization") String token, @RequestBody WorkRecord workRecord){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(workRecord));
        int result = staffService.insertWorkRecord(workRecord);
        return new RestfulResult(200, "新增工作经历！", result);
    }

    /**
     * 更新工作经历（记录）
     * @param token
     * @return
     */
    @PatchMapping("/api/staffs/personal/workRecord")
    @ApiOperation(value = "更新工作经历（记录）")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult editWorkRecord(@RequestHeader("Authorization") String token, @RequestBody WorkRecord workRecord){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(workRecord));
        int result = staffService.updateWorkRecord(workRecord);
        return new RestfulResult(200, "更新工作经历操作成功！", result);
    }










    /**
     * 删除培训经历（记录）
     * @param token
     * @return
     */
    @DeleteMapping("/api/staffs/personal/trainRecord/{trainRecordId}")
    @ApiOperation(value = "删除培训经历")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult deleteTrainRecord(@RequestHeader("Authorization") String token, @PathVariable("trainRecordId")Integer trainRecordId){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ trainRecordId);
        int result = staffService.deleteTrainRecord(trainRecordId);
        return new RestfulResult(200, "删除培训经历操作成功！", result);
    }

    /**
     * 新增培训经历（记录）
     * @param token
     * @return
     */
    @PostMapping("/api/staffs/personal/trainRecord")
    @ApiOperation(value = "新增培训经历")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult addTrainRecord(@RequestHeader("Authorization") String token, @RequestBody TrainRecord trainRecord){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(trainRecord));
        int result = staffService.insertTrainRecord(trainRecord);
        return new RestfulResult(200, "新增培训经历！", result);
    }

    /**
     * 更新培训经历（记录）
     * @param token
     * @return
     */
    @PatchMapping("/api/staffs/personal/trainRecord")
    @ApiOperation(value = "更新培训经历（记录）")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    public RestfulResult editTrainRecord(@RequestHeader("Authorization") String token, @RequestBody TrainRecord trainRecord){
        LOG.info("request---token>"+token);
        LOG.info("data=======>"+ JSONObject.toJSON(trainRecord));
        int result = staffService.updateTrainRecord(trainRecord);
        return new RestfulResult(200, "更新培训经历操作成功！", result);
    }


}
