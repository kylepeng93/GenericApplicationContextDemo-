package com.github.kylepeng93.domain.loginManagement.dto;

import lombok.Data;

/**
 * 用户登陆请求
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 下午9:35
 */
@Data
public class UserLoginRequest {
    private String userName;

    private String password;

    private Boolean rememberMe;
}
