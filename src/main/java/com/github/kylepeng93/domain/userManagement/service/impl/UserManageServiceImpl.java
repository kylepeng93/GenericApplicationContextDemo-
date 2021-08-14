package com.github.kylepeng93.domain.userManagement.service.impl;

import com.github.kylepeng93.domain.userManagement.service.UserManageService;
import com.github.kylepeng93.pojo.UserPojo;
import com.github.kylepeng93.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息服务类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 上午12:04
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserService userService;

    @Override
    public List<UserPojo> getUsers() {
        return userService.getUsers();
    }

    /**
     * 添加用户
     *
     * @param userPojo
     * @return
     */
    @Override
    public Boolean addUser(UserPojo userPojo) {
        if (userService.addUser(userPojo) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 更新用户
     *
     * @param userPojo
     * @return
     */
    @Override
    public Boolean updateUser(UserPojo userPojo) {
        if (userService.updateUser(userPojo) > 0) {
            return true;
        }
        return false;
    }
}
