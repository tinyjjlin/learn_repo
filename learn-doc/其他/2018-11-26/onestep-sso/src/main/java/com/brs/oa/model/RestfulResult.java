package com.brs.oa.model;

import java.io.Serializable;

public class RestfulResult  implements Serializable {
	private static final long serialVersionUID = -8474378445466770820L;
	private Integer code;
    private String msg;


    public RestfulResult(){}
    public RestfulResult(int code, String msg){
        this.code  = code;
        this.msg = msg;
    }


	public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
