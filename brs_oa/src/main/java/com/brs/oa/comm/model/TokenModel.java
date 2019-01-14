package com.brs.oa.comm.model;


import lombok.Data;

import java.io.Serializable;

/**
 * redis 中保存的<key,value>
 * @author tiny lin
 * @date  2018/12/5
*/
@Data
public class TokenModel implements Serializable {


    private String  loginName;
    private String token;

    public TokenModel(String loginName , String token){
       this.loginName = loginName;
       this.token = token;
    }


}
