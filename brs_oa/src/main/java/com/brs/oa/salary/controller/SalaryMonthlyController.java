package com.brs.oa.salary.controller;



import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.annotation.NeedPermissions;
import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.salary.model.SalaryTableModel;
import com.brs.oa.salary.service.ISalaryMonthlyService;
import com.brs.oa.vofield.service.IVoFieldService;
import com.brs.oa.vofield.vo.FieldVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@RestController
public class SalaryMonthlyController {


    private static final Log LOG = LogFactory.getLog(SalaryMonthlyController.class);

    @Autowired
    private IVoFieldService voFieldService;
    @Autowired
    private ISalaryMonthlyService salaryMonthlyService;


    /**
     * 薪资查询（拥有权限的人才能查看员工的记录，一般为财务组）
     * @param empNo
     * @param startTime
     * @param endTime
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "财务组查看员工薪资记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "staffId", value = "员工工号", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始月份", dataType = "Date"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "截止月份", dataType = "Date"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/api/salaries/search")
    @NeedPermissions("salaryReportView")
    public RestfulResult searchStaffSalaryList(@RequestHeader("Authorization") String token,@RequestParam(value = "staffId",required = true)Integer empNo, @RequestParam(value = "startTime",required = false) Date  startTime, @RequestParam(value = "endTime",required = false) Date endTime, @RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false,defaultValue = "1") Integer size){
        LOG.info("staffList--------->empNo:"+empNo);
        LOG.info("staffList--------->startTime:"+startTime+"-------->endTime:"+endTime);
        Integer currentEmpNo = JwtSupport.getEmployeeNo(token);
        List<FieldVo> fieldVoList = voFieldService.getFieldListByEmpNoAndVoName(currentEmpNo, "ComplexSalaryVo");
        PageHelper.startPage(page,size );
        PageInfo pageInfo = new PageInfo(salaryMonthlyService.getSalaryList(empNo, startTime,endTime ));
        return new RestfulResult(200,"查看所有员工工资",new SalaryTableModel(fieldVoList, pageInfo));
    }




    /**
     * 员工查看自己的薪资情况
     * @param token
     * @param page
     * @param size
     * @return
     */

    @ApiOperation(value = "我的薪资记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/api/personal/salaries")
    @Authentication
    public RestfulResult searchPersonalSalaryList(@RequestHeader("Authorization") String token, @RequestParam(value = "startTime",required = false) Date  startTime, @RequestParam(value = "endTime",required = false) Date endTime,@RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(value = "limit" ,required = false,defaultValue = "10") Integer size){
        Integer empNo = JwtSupport.getEmployeeNo(token);
        PageHelper.startPage(page,size );
       PageInfo pageInfo = new PageInfo(salaryMonthlyService.getPersonalSalaryList(empNo, startTime,endTime ));
        return new RestfulResult(200,"我的薪资记录",pageInfo);
    }



}
