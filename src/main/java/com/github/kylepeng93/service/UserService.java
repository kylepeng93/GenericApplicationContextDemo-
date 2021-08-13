package com.github.kylepeng93.service;

import com.github.kylepeng93.pojo.UserPojo;

import java.util.List;

/**
 * 用户DAO层服务接口
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 上午12:05
 */
public interface UserService {
    /**
     * 获取用户信息
     * @return
     */
    List<UserPojo> getUsers();

    /**
     * 添加用户
     */
    int addUser(UserPojo userPojo);
}
