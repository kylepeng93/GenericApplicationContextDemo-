package com.github.kylepeng93.domain.loginManagement.controller;

import com.github.kylepeng93.common.CommonResponse;
import com.github.kylepeng93.domain.loginManagement.dto.UserLoginRequest;
import com.github.kylepeng93.domain.loginManagement.service.LoginService;
import com.github.kylepeng93.pojo.UserPojo;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("login")
    public CommonResponse<Boolean> login(@RequestBody UserLoginRequest request) {
        return CommonResponse.success(loginService.login(request));
    }

    @PostMapping("register")
    public CommonResponse<Boolean> register(@RequestBody UserPojo userPojo) {
        return CommonResponse.success(loginService.register(userPojo));
    }
}
