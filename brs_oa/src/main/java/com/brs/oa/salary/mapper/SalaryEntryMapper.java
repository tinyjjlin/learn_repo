package com.brs.oa.salary.mapper;


import com.brs.oa.salary.entity.SalaryEntry;
import com.brs.oa.salary.entity.SocialInsuranceEntry;
import com.brs.oa.staff.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 工资项目 Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
public interface SalaryEntryMapper{

    /**
     * 根据工资套帐类别获取其套帐字段
     * @param category
     * @return
     */
    List<SalaryEntry> selectListByCategory(@Param("category")String category);



    /**
     * 插入新的工资套帐
     * @param salaryTemplateCategory 工资套帐类别
     * @param siEntryList
     * @return
     */
    int insertOne(@Param("category")String salaryTemplateCategory,@Param("list")List<SalaryEntry> siEntryList);


    /**
     * 社保账号关联员工
     * @param salaryTemplateCategory 工资套帐类别
     * @param empNoList
     * @return
     */
    int insertRelatedSaffList(@Param("category")String salaryTemplateCategory,@Param("list")List<Integer>empNoList);


}
