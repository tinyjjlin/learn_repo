package com.beruosi.oav1.controller;

import com.beruosi.oav1.annotation.NoNeedToken;
import com.beruosi.oav1.annotation.UserToken;
import com.beruosi.oav1.model.ResponseResult;
import com.beruosi.oav1.util.JwtSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    Logger log =LoggerFactory.getLogger(getClass());


    @PostMapping("/login")
    @NoNeedToken
    public ResponseResult<Map> login(@RequestParam("userName")String userName, @RequestParam("password")String password, HttpServletResponse resp){
        // visit ldap data  to check userinfo
         log.info("userName:"+userName+",password:"+password);
        //if success
         String currentTimeMillis = String.valueOf(System.currentTimeMillis());
         String token = JwtSupport.sign(userName,currentTimeMillis);
         //方式一：
        resp.setHeader("token",token );

         //方式二，将token 保持在 body
        HashMap<String,String>valueMap = new HashMap<>();
        valueMap.put("token",token);
        return new ResponseResult(200, "login success!",valueMap);
    }
    @PostMapping("/access")
    @UserToken
    public String index(){
        //parse header
        return "success";
    }
}
