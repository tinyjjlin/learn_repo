package com.brs.oa.comm.model;

import lombok.Data;


/**
 * controller统一返回的json数据格式
 * @author tiny lin
 * @date  2018/12/5
*/
@Data
public class RestfulResult {
    private Integer code;
    private String msg;
    private Object data;

   public RestfulResult(int code,String msg){
        this(code,msg,null);
   }
    public RestfulResult(int code, String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
