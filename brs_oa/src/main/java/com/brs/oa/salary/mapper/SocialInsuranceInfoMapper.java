package com.brs.oa.salary.mapper;


import com.brs.oa.salary.entity.SocialInsuranceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工社保（五险一金）信息 Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
public interface SocialInsuranceInfoMapper {

    /**
     * 添加员工社保信息
     * @param socialInsuranceInfoList
     * @return
     */
    int insertList(@Param("list")List<SocialInsuranceInfo> socialInsuranceInfoList);
}
