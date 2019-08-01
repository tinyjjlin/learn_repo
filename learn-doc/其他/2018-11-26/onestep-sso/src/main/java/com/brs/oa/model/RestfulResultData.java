package com.brs.oa.model;

public class RestfulResultData extends  RestfulResult {
    private Object data;
    public RestfulResultData(Integer code,String msg){
        super(code,msg);

    }
    public RestfulResultData(Integer code, String msg, Object data){
        super(code,msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
