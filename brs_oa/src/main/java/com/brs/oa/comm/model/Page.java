package com.brs.oa.comm.model;

import lombok.Data;

/**
 * 分页对象
 * @author tiny lin
 * @date 2018/12/10
 */
@Data
public class Page {
    private Integer pageNum;
    private Integer pageSize;

    public Page(int pageNum,int pageSize){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
