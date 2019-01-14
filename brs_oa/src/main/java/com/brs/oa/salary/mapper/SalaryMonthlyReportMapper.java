package com.brs.oa.salary.mapper;

import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.salary.vo.SimpleSalaryVo;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/10
 */
public interface SalaryMonthlyReportMapper {

    /**
     * 员工查看自己的薪资记录
     * @param empNo
     * @param startTime
     * @param endTime
     * @return
     */

    List<SimpleSalaryVo> queryPersonalSalaryList(@Param("empNo") Integer empNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 员工薪资查询
     * @param empNo
     * @param startTime
     * @param endTime
     * @return
     */
    List<ComplexSalaryVo> querySalaryList(@Param("empNo") Integer empNo, @Param("startTime") Date startTime,@Param("endTime") Date endTime);


}
