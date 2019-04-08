package com.brs.oa.salary.model;

import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.vofield.vo.FieldVo;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/13
 */
@Data
public class SalaryTableModel {
    private List<FieldVo> columnList;
    private PageInfo rowList;

    public SalaryTableModel(List<FieldVo> columnList,PageInfo rowList){
        this.columnList = columnList;
        this.rowList = rowList;
    }
}
