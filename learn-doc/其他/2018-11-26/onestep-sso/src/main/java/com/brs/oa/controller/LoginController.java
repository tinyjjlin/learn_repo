package com.brs.oa.controller;

import com.auth0.jwt.JWT;
import com.brs.oa.comm.jwt.TokenClaimFactory;
import com.brs.oa.model.LoginUser;
import com.brs.oa.model.RestfulResult;
import com.brs.oa.model.RestfulResultData;

import com.brs.oa.comm.jwt.JWTUtil;
import com.brs.oa.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public RestfulResult login(@RequestParam("userCode") String userCode, @RequestParam("password") String password) throws Exception {
        LoginUser loginUser = loginService.authentication(userCode, password);
        return new RestfulResultData(200, "login success!", JWTUtil.genereateToken(loginUser));
    }
}
