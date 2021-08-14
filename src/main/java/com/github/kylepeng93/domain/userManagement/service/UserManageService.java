package com.github.kylepeng93.domain.userManagement.service;

import com.github.kylepeng93.pojo.UserPojo;

import java.util.List;

/**
 * 用户信息服务接口
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 上午12:03
 */
public interface UserManageService {
    /**
     * 获取全量用户信息
     * @return
     */
    List<UserPojo> getUsers();

    /**
     * 添加用户
     * @param userPojo
     * @return
     */
    Boolean addUser(UserPojo userPojo);

    /**
     * 更新用户
     * @param userPojo
     * @return
     */
    Boolean updateUser(UserPojo userPojo);
}
