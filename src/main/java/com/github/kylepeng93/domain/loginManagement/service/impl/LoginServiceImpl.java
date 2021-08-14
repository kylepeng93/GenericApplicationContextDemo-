package com.github.kylepeng93.domain.loginManagement.service.impl;

import com.github.kylepeng93.domain.loginManagement.dto.UserLoginRequest;
import com.github.kylepeng93.domain.loginManagement.service.LoginService;
import com.github.kylepeng93.pojo.UserPojo;
import org.springframework.stereotype.Service;

/**
 * 登陆服务实现类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 下午8:10
 */
@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 登陆验证
     * @param request
     * @return
     */
    @Override
    public Boolean login(UserLoginRequest request) {
        return true;
    }

    /**
     * 用户注册
     *
     * @param userPojo
     * @return
     */
    @Override
    public Boolean register(UserPojo userPojo) {
        return true;
    }
}
