package com.github.kylepeng93.service;

import com.github.kylepeng93.pojo.SysRolePojo;

import java.util.List;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午10:44
 */
public interface SysRoleService {
    /**
     * 查询用户id对应的系统角色
     * @param userId
     * @return
     */
    List<SysRolePojo> selectSysRoleByUserId(Long userId);
}
