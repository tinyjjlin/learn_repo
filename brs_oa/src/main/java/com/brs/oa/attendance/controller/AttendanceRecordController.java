//package com.brs.oa.attendance.controller;
//
//
//import com.brs.oa.attendance.service.IAttendanceRecordService;
//import com.brs.oa.attendance.vo.AttendanceRecordVo;
//import com.brs.oa.comm.jwt.JwtSupport;
//import com.brs.oa.comm.model.RestfulResult;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.sql.Date;
//import java.sql.Timestamp;
//
//import java.util.List;
//
///**
// * <p>
// * 考勤（打卡）记录 前端控制器
// * </p>
// *
// * @author tiny lin
// * @since 2018-12-18
// */
//@RestController
//
//public class AttendanceRecordController {
//
//    @Autowired
//    private IAttendanceRecordService attendanceRecordService;
//    @GetMapping("/api/attendanceRecord/all")
//    @ApiImplicitParam(paramType = "query", name = "selectedDate", value = "指定日期", dataType = "Date")
//    public RestfulResult personalAttendanceRecord(@RequestHeader("Authorization")String token, @RequestParam("selectedDate") Date selectedDate){
//        Integer empNo = JwtSupport.getEmployeeNo(token);
//        System.out.println("empno...................."+empNo);
//        System.out.println("attendance.......selectedDate......"+selectedDate + "type---->"+selectedDate.getClass());
//       List<Timestamp>  recordList = attendanceRecordService.getRecordList(empNo,selectedDate );
//        return new RestfulResult(200,"查询自己的考勤记录操作成功！",recordList );
//    }
//
//    /**
//     * 个人查看考勤记录
//     * @param token
//     * @param startTime
//     * @param endTime
//     * @param page
//     * @param size
//     * @return
//     */
//    @ApiOperation(value = "个人查看考勤记录")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始日期", dataType = "Date"),
//            @ApiImplicitParam(paramType = "query", name = "endTime", value = "截止日期", dataType = "Date"),
//            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
//            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的行数", dataType = "int", defaultValue = "10")
//    })
//    @GetMapping("/api/personal/attendanceRecord")
//    public RestfulResult personalAttendanceRecordList(@RequestHeader("Authorization") String token, @RequestParam(value = "startTime",required = false) Date  startTime, @RequestParam(value = "endTime",required = false) Date endTime, @RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false,defaultValue = "10") Integer size){
//
//        Integer empNo = JwtSupport.getEmployeeNo(token);
//       List<AttendanceRecordVo> attendanceRecordVoList = attendanceRecordService.getRecordListRange(empNo, startTime,endTime );
//
//        PageHelper.startPage(page,size );
//        PageInfo pageInfo = new PageInfo(attendanceRecordVoList);
//        return new RestfulResult(200,"查询自己的考勤记录操作成功！",pageInfo );
//    }
//
//    /**
//     * 人事查看员工考勤记录
//     * @param empNo
//     * @param startTime
//     * @param endTime
//     * @param page
//     * @param size
//     * @return
//     */
//    @ApiOperation(value = "人事查看员工考勤记录")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", name = "staffId", value = "员工工号", dataType = "int"),
//            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始日期", dataType = "Date"),
//            @ApiImplicitParam(paramType = "query", name = "endTime", value = "截止日期", dataType = "Date"),
//            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
//            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的行数", dataType = "int", defaultValue = "10")
//    })
//    @GetMapping("/api/attendanceRecord")
//    public RestfulResult attendanceRecordList(@RequestParam("staffId")Integer empNo, @RequestParam(value = "startTime",required = false) Date  startTime, @RequestParam(value = "endTime",required = false) Date endTime, @RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false,defaultValue = "10") Integer size){
//
//        List<AttendanceRecordVo> attendanceRecordVoList = attendanceRecordService.getRecordListRange(empNo, startTime,endTime );
//
//        PageHelper.startPage(page,size );
//        PageInfo pageInfo = new PageInfo(attendanceRecordVoList);
//        return new RestfulResult(200,"人事查看员工考勤记录操作成功！",pageInfo );
//    }
//
//}
