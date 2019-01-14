package com.brs.oa.vofield.mapper;

import com.brs.oa.vofield.vo.FieldVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface VoFieldMapper {

    /**
     * 获取其可以查看的视图字段
     * @param empNo
     * @param VoName
     * @return
     */
    public List<FieldVo> queryByEmpNoAndVoName(@Param("empNo") Integer empNo, @Param("voName") String VoName);
}
