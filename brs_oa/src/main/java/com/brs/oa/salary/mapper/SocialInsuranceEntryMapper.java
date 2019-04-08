package com.brs.oa.salary.mapper;


import com.brs.oa.salary.entity.SocialInsuranceEntry;
import com.brs.oa.staff.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 五险一金模板（条目） Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
public interface SocialInsuranceEntryMapper  {
    /**
     * 根据社保类别获取其套帐数据
     * @param category
     * @return
     */
    List<SocialInsuranceEntry> selectListByCategory(@Param("category")String category);

    /**
     * 根据员工号查找其对应的社保套账
     * @param empNo
     * @return
     */
    List<SocialInsuranceEntry> selectListByByEmpNo(@Param("empNo")Integer empNo);

    /**
     * 查看指定社保套账关联的员工列表
     * @param category
     * @return
     */
    List<Staff> selectStaffListByCategory(@Param("category")String category);
    /**
     * 插入新的社保套帐
     * @param siCategory
     * @param siEntryList
     * @return
     */
    int insertOne(@Param("category")String siCategory,@Param("list")List<SocialInsuranceEntry> siEntryList);


    /**
     * 社保账号关联员工
     * @param siCategory
     * @param empNoList
     * @return
     */
    int insertRelatedSaffList(@Param("category")String siCategory,@Param("list")List<Integer>empNoList);


}
