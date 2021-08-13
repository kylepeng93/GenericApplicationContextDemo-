package com.github.kylepeng93.domain.userManagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.kylepeng93.common.CommonResponse;
import com.github.kylepeng93.domain.userManagement.service.UserManageService;
import com.github.kylepeng93.pojo.UserPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息控制器
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-13 下午11:40
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @GetMapping("getUsers")
    public CommonResponse<List<UserPojo>> getUsers() {
        log.info("开始查询用户信息");
        return CommonResponse.success(userManageService.getUsers());
    }

    @PostMapping("addUser")
    public CommonResponse<Boolean> addUser(@RequestBody UserPojo userPojo) {
        log.info("addUser--入参--{}" , JSONObject.toJSONString(userPojo));
        return CommonResponse.success(userManageService.addUser(userPojo));
    }
}
