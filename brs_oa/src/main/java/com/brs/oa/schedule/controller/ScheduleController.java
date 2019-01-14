package com.brs.oa.schedule.controller;


import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.schedule.entity.Schedule;
import com.brs.oa.schedule.service.IScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 排班（班次） 前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-09
 */
@Api
@RestController
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @ApiOperation(value = "保存考勤参数设置")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    })
    @PostMapping("/api/schedule")
    public RestfulResult  add(@RequestHeader("Authorization") String token, @RequestBody Schedule schedule){
           Integer empNo = JwtSupport.getEmployeeNo(token);
           schedule.setStaffEmpNo(empNo);

           int result = scheduleService.edit(schedule);

           return new RestfulResult(200,"添加考察参数成功",result );
    }


    @ApiOperation(value = "查看考勤参数设置")
    @GetMapping("/api/schedule")
    public RestfulResult  search(){
        Schedule schedule = scheduleService.selectOne();
        return new RestfulResult(200,"查看考勤参数",schedule);
    }

}
