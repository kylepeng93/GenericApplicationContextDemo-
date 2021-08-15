package com.github.kylepeng93.domain.userManagement.service.impl;

import com.github.kylepeng93.domain.userManagement.dto.SysUserDto;
import com.github.kylepeng93.domain.userManagement.service.UserManageService;
import com.github.kylepeng93.pojo.SysUserPojo;
import com.github.kylepeng93.pojo.UserPojo;
import com.github.kylepeng93.service.SysUserService;
import com.github.kylepeng93.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    private SysUserService userService;

    /**
     * 查询查询
     *
     * @return
     */
    @Override
    public List<SysUserDto> selectUserConditional(SysUserPojo userPojo) {
        return userService.selectUserConditional(userPojo).stream()
                .map(SysUserDto::convert)
                .collect(Collectors.toList());
    }

    /**
     * 添加用户
     *
     * @param userPojo
     * @return
     */
    @Override
    public Boolean addUser(SysUserPojo userPojo) {

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
    public Boolean updateUser(SysUserPojo userPojo) {
        if (userService.updateUser(userPojo) > 0) {
            return true;
        }
        return false;
    }
}
