package com.github.kylepeng93.domain.userManagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.kylepeng93.common.CommonResponse;
import com.github.kylepeng93.domain.userManagement.dto.SysUserDto;
import com.github.kylepeng93.domain.userManagement.service.UserManageService;
import com.github.kylepeng93.pojo.SysUserPojo;
import com.github.kylepeng93.pojo.UserPojo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.slf4j.MDC;
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
@RequestMapping("/api/userManage")
@Slf4j
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @GetMapping("getUsers")
    public CommonResponse<List<SysUserDto>> getUsers(SysUserPojo pojo) {
        log.info("开始查询用户信息");
        return CommonResponse.success(userManageService.selectUserConditional(pojo));
    }

    @PostMapping("addUser")
    public CommonResponse<Boolean> addUser(@RequestBody SysUserPojo userPojo) {
        log.info("addUser--入参--{}" , JSONObject.toJSONString(userPojo));
        return CommonResponse.success(userManageService.addUser(userPojo));
    }

    @PutMapping("updateUser")
    public CommonResponse<Boolean> updateUser(@RequestBody SysUserPojo userPojo) {
        log.info("updateUser--入参--{}" , JSONObject.toJSONString(userPojo));
        return CommonResponse.success(userManageService.updateUser(userPojo));
    }
}
