package com.brs.oa.salary.service;



import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.salary.vo.SimpleSalaryVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
public interface ISalaryMonthlyService  {


    /**
     * 分页获取个人工资报表信息
     * @param empNo
     * @param startTime
     * @param endTime
     * @param page
     * @return
     */
    PageInfo<SimpleSalaryVo> getPersonalSalaryListByPage(Integer empNo, Date startTime,Date endTime, Page page);

    /**
     * 获取个人工资报表信息
     * @param empNo
     * @param startTime
     * @param endTime
     * @return
     */
    List<SimpleSalaryVo> getPersonalSalaryList(Integer empNo, Date startTime,Date endTime);


    /**
     * 分页查询指定员工的工资报表信息
     * @param empNo
     * @param startTime
     * @param endTime
     * @param page
     * @return
     */
     PageInfo<ComplexSalaryVo> getSalaryListByPage(Integer empNo, Date startTime, Date endTime, Page page);

    /**
     * 查询指定员工的工资报表信息
     * @param empNo
     * @param startTime
     * @param endTime
     * @return
     */
     List<ComplexSalaryVo> getSalaryList(Integer empNo, Date startTime,Date endTime);

    /**
     * 按字段权限显示每个人的工资条
     * @param empNo
     * @return
     */
  //  JSONObject getOwnSalaryInfoFilter(Integer empNo);



    /**
     * 按字段权限获取员工工资信息
     * @param page
     * @return
     */
   // public JSONArray  getPageListFilter(Page<ComplexSalaryVo> page);

}
