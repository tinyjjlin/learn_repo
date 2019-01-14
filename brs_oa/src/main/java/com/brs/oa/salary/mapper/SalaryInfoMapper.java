package com.brs.oa.salary.mapper;


import com.brs.oa.salary.entity.SalaryInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工工资信息 Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
public interface SalaryInfoMapper {

    /**
     * 添加员工工资信息
     * @param salaryInfoList
     * @return
     */
    int insertList(@Param("list")List<SalaryInfo> salaryInfoList);

}
