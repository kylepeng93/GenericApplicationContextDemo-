package com.github.kylepeng93.service;

import com.github.kylepeng93.pojo.SysUserPojo;

import java.util.List;

/**
 * 系统用户业务接口
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午12:59
 */
public interface SysUserService {

    /**
     * 条件查询
     * @param userPojo
     * @return
     */
    List<SysUserPojo> selectUserConditional(SysUserPojo userPojo);

    /**
     * 添加用户
     */
    Integer addUser(SysUserPojo userPojo);

    /**
     * 更新用户信息
     * @param userPojo
     * @return
     */
    Integer updateUser(SysUserPojo userPojo);
}
