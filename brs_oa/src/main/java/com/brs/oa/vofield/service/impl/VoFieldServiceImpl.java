package com.brs.oa.vofield.service.impl;

import com.brs.oa.vofield.mapper.VoFieldMapper;
import com.brs.oa.vofield.service.IVoFieldService;
import com.brs.oa.vofield.vo.FieldVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@Service
public class VoFieldServiceImpl implements IVoFieldService {

    @Autowired(required = false)
    private VoFieldMapper voFieldMapper;


    @Override
    public Map<String, FieldVo> getFieldMapByEmpNoAndVoName(Integer empNo, String voName) {
        List <FieldVo> list = getFieldListByEmpNoAndVoName(empNo,voName );
        System.out.println("list:--->" + list.size());
        //处理没有字段限制情况
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        Map <String, FieldVo> columnMap = new HashMap<>(list.size());
        for (FieldVo column : list) {
            //将字段名与权限表字段对应
            System.out.println("column---field:--->" + column.getFieldName());
            columnMap.put(column.getFieldName(), column);

        }
        return columnMap;
    }

    @Override
    public List<FieldVo> getFieldListByEmpNoAndVoName(Integer empNo, String voName) {
        return voFieldMapper.queryByEmpNoAndVoName(empNo,voName);
    }
}
