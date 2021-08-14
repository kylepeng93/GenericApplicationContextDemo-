package com.github.kylepeng93.domain.loginManagement.service;

import com.github.kylepeng93.domain.loginManagement.dto.UserLoginRequest;
import com.github.kylepeng93.pojo.UserPojo;

/**
 * 登陆服务
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 下午8:10
 */
public interface LoginService {
    /**
     * 登陆验证
     * @param request
     * @return
     */
    Boolean login(UserLoginRequest request);

    /**
     * 用户注册
     * @param userPojo
     * @return
     */
    Boolean register(UserPojo userPojo);
}
