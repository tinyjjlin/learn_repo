package com.brs.oa.vofield.service;

import com.brs.oa.vofield.vo.FieldVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface IVoFieldService {
    /**
     * 根据员工号，和页面视图名 获取当前员工可以访问的字段列表
     * @param empNo
     * @param voName
     * @return
     */
    public List<FieldVo> getFieldListByEmpNoAndVoName(Integer empNo, String voName);

    /**
     * 根据员工号，和页面视图名 获取当前员工可以访问的字段Map
     * @param empNo
     * @param voName
     * @return
     */
    public Map<String, FieldVo> getFieldMapByEmpNoAndVoName(Integer empNo, String voName) ;
}
