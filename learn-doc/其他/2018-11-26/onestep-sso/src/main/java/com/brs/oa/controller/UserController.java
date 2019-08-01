package com.brs.oa.controller;

import com.brs.oa.comm.annotation.Logical;
import com.brs.oa.comm.annotation.NeedPermissions;
import com.brs.oa.comm.annotation.RequestFieldAuth;
import com.brs.oa.model.RestfulResult;
import com.brs.oa.model.RestfulResultData;
import com.brs.oa.service.impl.UserServiceImpl;
import com.brs.oa.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/view")
    @NeedPermissions(logical = Logical.OR, value = {"user:view", "user:edit"})
    public RestfulResult listUser(HttpServletRequest request) {
        String userCode = CommonUtil.getCurrentUserCodeFromToken(request);
        return new RestfulResultData(200, "allow view user list!",  userService.findUser3());
    }

    @PostMapping("/edit")
    @NeedPermissions(value = {"user:edit"})
    @RequestFieldAuth(dtoName = "UserDTO")
    public RestfulResult addUser(HttpServletRequest request) {
        String userCode = CommonUtil.getCurrentUserCodeFromToken(request);
        return new RestfulResult(200, "allow add user !");
    }

    @PostMapping("/delete")
    @NeedPermissions(value = {"user:delete"})
    public RestfulResult deleteUser(HttpServletRequest request) {
        String userCode = CommonUtil.getCurrentUserCodeFromToken(request);
        return new RestfulResult(200, "allow delete user !");
    }

}
