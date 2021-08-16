package com.github.kylepeng93.domain.loginManagement.controller;

import com.github.kylepeng93.common.CommonResponse;
import com.github.kylepeng93.common.shiro.ShiroUtils;
import com.github.kylepeng93.domain.loginManagement.dto.UserLoginRequest;
import com.github.kylepeng93.domain.loginManagement.service.LoginService;
import com.github.kylepeng93.pojo.UserPojo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登陆控制器
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 下午8:07
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public CommonResponse<String> login(@RequestBody UserLoginRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(request.getUserName(), request.getPassword());
            // 执行登陆
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            return CommonResponse.unauthorized(e.getMessage());
        } catch (LockedAccountException e) {
            return CommonResponse.forbidden(e.getMessage());
        } catch (AuthenticationException e) {
            return CommonResponse.failed(e.getMessage());
        } catch (Exception e) {
            return CommonResponse.failed();
        }
        // 返回token
        return CommonResponse.success(ShiroUtils.getSession().getId().toString());
    }

    @PostMapping("/register")
    public CommonResponse<Boolean> register(@RequestBody UserPojo userPojo) {
        return CommonResponse.success(loginService.register(userPojo));
    }
}
