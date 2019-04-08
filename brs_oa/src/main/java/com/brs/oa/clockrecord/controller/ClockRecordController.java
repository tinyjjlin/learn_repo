package com.brs.oa.clockrecord.controller;


import com.brs.oa.clockrecord.entity.ClockRecord;
import com.brs.oa.clockrecord.service.IClockRecordService;
import com.brs.oa.clockrecord.vo.ClockRecordVo;
import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.util.CalendarSupport;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 打卡记录 前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-09
 */
@RestController
@Api("打卡记录模块")
public class ClockRecordController {
    @Autowired
    private IClockRecordService clockRecordService;

    @ApiOperation(value = "保存打卡记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true)
    })
    /**
     * 个人保存打卡记录
     */
    @PostMapping("/api/clockRecord")
    public RestfulResult save(@RequestHeader("Authorization") String token, @RequestBody ClockRecord clockRecord){
        Integer empNo = JwtSupport.getEmployeeNo(token);
        clockRecord.setEmpNo(empNo);
        int result = clockRecordService.save(clockRecord);
        return new RestfulResult(200,"保存打卡记录成功",result );
    }
    /**
     * 个人查看打卡记录
     * @param token
     * @param selectedDate
     * @return
     */
    @ApiOperation(value = "查看个人打卡记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query", name = "selectedDate", value = "指定日期", dataType = "Date")
    })
    @GetMapping("/api/personal/clockRecord")
    public RestfulResult personalClockRecordList(@RequestHeader("Authorization") String token, @PathParam("selectedDate") Date selectedDate){
        Integer empNo = JwtSupport.getEmployeeNo(token);
        System.out.println("selectedDate----------================>"+selectedDate+",empNo--->"+empNo);

        String selectDateStr = null;
        if(selectedDate != null){
            selectDateStr = CalendarSupport.dateToStr(selectedDate);
        }
        System.out.println("selectedDate-----str-----================>"+selectDateStr);
        List<ClockRecordVo> clockRecordVoList = clockRecordService.selectClockRecordList(empNo,selectDateStr);
        PageInfo pageInfo = new PageInfo(clockRecordVoList);
        return  new RestfulResult(200,"查看指定日期的打卡记录",pageInfo);
    }
    @ApiOperation(value = "查看员工打卡记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token值", dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query", name = "empNo", value = "员工号", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "selectedDate", value = "指定日期", dataType = "Date")
    })

    @GetMapping("/api/clockRecord")
    public RestfulResult clockRecordList(@PathParam("empNo")Integer empNo, @PathParam("selectedDate") Date selectedDate){
        String selectDateStr = null;
        if(selectedDate != null){
            selectDateStr = CalendarSupport.dateToStr(selectedDate);
        }

        List<ClockRecordVo> clockRecordVoList = clockRecordService.selectClockRecordList(empNo, selectDateStr);
        PageInfo pageInfo = new PageInfo(clockRecordVoList);
        return  new RestfulResult(200,"查看打卡记录",pageInfo);
    }




}
