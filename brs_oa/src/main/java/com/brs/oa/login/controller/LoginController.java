package com.brs.oa.login.controller;

import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.login.dto.LoginDto;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.comm.model.TokenModel;
import com.brs.oa.login.dto.UserInfoDto;
import com.brs.oa.login.service.ILdapService;
import com.brs.oa.login.service.ITokenService;
import com.brs.oa.role.service.IRoleService;
import com.brs.oa.staff.service.IStaffService;
import com.brs.oa.staff.vo.SimpleStaffVo;
import com.brs.oa.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tiny lin
 * @date 2018/11/29
 */
@RestController
@Api("用户登录接口")
public class LoginController {
    static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ILdapService ldapService;
    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IStaffService staffService;

    @Autowired
    private IRoleService  roleService;

    @PostMapping("/api/login")
    @ApiOperation(value = "用户登录",notes = "用户名，密码就是登录计算机账号密码")
    public RestfulResult login(@RequestBody LoginDto loginDto) throws Exception {
       ldapService.authentication(loginDto);
        LOG.info("user login===============================>"+loginDto.getUsername()+","+loginDto.getPassword());
        TokenModel tokenModel = tokenService.generateToken(loginDto.getUsername(),CommonUtil.getEmpNo(loginDto.getUsername()));
        return new RestfulResult(200, "登录成功!", tokenModel);
    }
    @GetMapping("/api/logout")
    @ApiOperation(value = "退出系统")
    @Authentication
    public RestfulResult logout(HttpServletRequest request){
        String token =CommonUtil.getTokenFromRequest(request);
        tokenService.deleteToken(JwtSupport.getLoginName(token));
        return new RestfulResult(200, "退出操作成功!");
    }

    @GetMapping("/api/login/userInfo")
    @ApiOperation(value = "获取登录用户基本信息")
    public RestfulResult userInfo(@RequestHeader("Authorization")String token){
          Integer empNo = JwtSupport.getEmployeeNo(token);
        SimpleStaffVo simpleSalaryVo = staffService.getStaffBaseInfo(empNo);
        List<String> roleList = roleService.getRoleNamesByEmpNo(empNo);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setAvatar(simpleSalaryVo.getPicture());
        userInfoDto.setName(simpleSalaryVo.getName());
        userInfoDto.setEmpNo(simpleSalaryVo.getEmpNo());
        userInfoDto.setRoles(roleList);
        userInfoDto.setIntroduction("贝偌偲员工");
        return new RestfulResult(200, "退出操作成功!",userInfoDto);
    }
}